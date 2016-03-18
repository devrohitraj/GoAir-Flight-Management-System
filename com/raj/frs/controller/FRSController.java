package com.raj.frs.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.FlightBean;
import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ProfileBean;
import com.raj.frs.bean.ReservationBean;
import com.raj.frs.bean.RouteBean;
import com.raj.frs.bean.ScheduleBean;
import com.raj.frs.service.Administrator;
import com.raj.frs.service.Customer;
import com.raj.frs.util.Authentication;
import com.raj.frs.util.Payment;
import com.raj.frs.util.User;
import com.raj.frs.util.UserImpl;

@Controller
public class FRSController {

	@Autowired
	private Administrator administratorService;

	@Autowired
	private Customer customerService;
	
	@Autowired
	User user;
	
	@Autowired
	Authentication authentication;
	
	@Autowired
	Payment payment;

	@RequestMapping(value = "log", method = RequestMethod.GET)
	public ModelAndView log(
			@ModelAttribute("credentialsBean") CredentialsBean credentialsBean) {
		ModelAndView modelAndView = new ModelAndView("Login");
		return modelAndView;
	}

	@RequestMapping(value = "UsrLogin", method = RequestMethod.POST)
	public ModelAndView UsrLogin(
			@ModelAttribute("credentialsBean") @Valid CredentialsBean credentialsBean,
			BindingResult result, HttpSession session) {
		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Login");
		} else {

			String logResult = user.login(credentialsBean);

			if (logResult.equals(null)) {
				modelAndView = new ModelAndView("Login");
				return modelAndView;

			} else if (logResult.equalsIgnoreCase("A")) {

				boolean bool = authentication.changeLoginStatus(
						credentialsBean, 1);
				
				session.setAttribute("status", credentialsBean
								.getLoginStatus());
				session.setAttribute("userId", credentialsBean.getUserID());
				System.out.println(session.getAttribute("status").toString());
				modelAndView = new ModelAndView("welcome");
				return modelAndView;

			} else if (logResult.equalsIgnoreCase("C")) {
				System.out.println(logResult);
				boolean bool = authentication.changeLoginStatus(
						credentialsBean, 1);
				
				session.setAttribute("status", credentialsBean
								.getLoginStatus());
				session.setAttribute("userId", credentialsBean.getUserID());
				modelAndView = new ModelAndView("header");
				return modelAndView;
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Login Fails");
				return modelAndView;
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "ncustomer", method = RequestMethod.GET)
	public ModelAndView ncustomer(
			@ModelAttribute("regBean") ProfileBean profileBean) {
		ModelAndView modelAndView = new ModelAndView("RegCustomer");
		return modelAndView;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView register(
			@ModelAttribute("regBean") @Valid ProfileBean profileBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("RegCustomer");
			System.out.println("Error" + result);
		} else {
			String insertResult = user.register(profileBean);
			System.out.println(insertResult);
			if (insertResult.equalsIgnoreCase("SUCCESS")) {
				modelAndView = new ModelAndView("Inserted");
				modelAndView.addObject("message", profileBean.getUserID());
				System.out.println("SUCCESS Redirected");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView
						.addObject("message",
								"We Are Extremely sorry for the inconvince Please Try Again Later");
				System.out.println("ERROR");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "book", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("mngBean") CredentialsBean creditcardBean) {
		ModelAndView modelAndView = new ModelAndView("ManageTicket");
		return modelAndView;
	}

	@RequestMapping(value = "ticket", method = RequestMethod.POST)
	public ModelAndView book(
			@ModelAttribute("mngBean") @Valid CredentialsBean creditcardBean,
			BindingResult result) {
		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			modelAndView = new ModelAndView("ManageTicket");
			System.out.println("MVERROR");
		} else {
			boolean bookResult = customerService.reserveTicket(reservationBean, passengers);
			System.out.println(bookResult);
			if (bookResult == true) {
				modelAndView = new ModelAndView("PaySucceed");
				modelAndView.addObject("uid", creditcardBean.getUserID());
				modelAndView.addObject("message", "Your Payment ");
				modelAndView.addObject("done", "is Done :)");
				System.out.println("Payment SuccessFull");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", creditcardBean.getUserID());
				System.out.println("ERROR");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "res", method = RequestMethod.GET)
	public ModelAndView home(
			@ModelAttribute("rsBean") ReservationBean reservationBean) {
		ArrayList<ScheduleBean> sclist = administratorService.fetchScheduleID();
		ArrayList<String> rslist = administratorService.fetchResType();
		ModelAndView modelAndView = new ModelAndView("ReserveTicket");
		modelAndView.addObject("lists", sclist);
		modelAndView.addObject("rslist", rslist);
		return modelAndView;
	}

	@RequestMapping(value = "reserve", method = RequestMethod.POST)
	public ModelAndView reserve(
			@ModelAttribute("rsBean") @Valid ReservationBean reservationBean,
			BindingResult result) {
		ModelAndView modelAndView = null;

		if (result.hasErrors()) {
			ArrayList<ScheduleBean> sclist = administratorService
					.fetchScheduleID();
			ArrayList<String> rslist = administratorService.fetchResType();
			modelAndView = new ModelAndView("ReserveTicket");
			modelAndView.addObject("lists", sclist);
			modelAndView.addObject("rslist", rslist);
			System.out.println("MVERROR" + result);
		} else {

			String retResult = customerService.reserveTicket(reservationBean);
			if (retResult.equals("Success")) {
				modelAndView = new ModelAndView("Passenger");
				modelAndView.addObject("seat", reservationBean.getNoofseats());
				modelAndView.addObject("rid", reservationBean
						.getReservationid());
				System.out.println(reservationBean.getReservationid());
				System.out.println("SUCCESS");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", reservationBean.getUserID());
				System.out.println("ERROR");
			}

		}
		return modelAndView;

	}

	@RequestMapping(value = "Logout", method = RequestMethod.GET)
	public ModelAndView Logout(
			@ModelAttribute("credentialsBean") CredentialsBean credentialsBean,
			HttpServletRequest req) {
		credentialsBean.setUserID(req.getParameter("userid"));
		boolean bool = administratorService.changeLoginStatus(credentialsBean,
				0);
		ModelAndView modelAndView = new ModelAndView("Logout");

		return modelAndView;

	}

	@RequestMapping(value = "home")
	public ModelAndView home(@ModelAttribute("flightBean") FlightBean flightBean) {
		ModelAndView modelAndView = new ModelAndView("flight_start");
		return modelAndView;
	}

	@RequestMapping(value = "manage_flight")
	public ModelAndView manage_flight(
			@ModelAttribute("flightBean") FlightBean flightBean) {
		ModelAndView modelAndView = new ModelAndView("flight");
		return modelAndView;
	}

	@RequestMapping(value = "new_flight", method = RequestMethod.GET)
	public ModelAndView new_flight(
			@ModelAttribute("flightBean") FlightBean flightBean) {
		ModelAndView modelAndView = new ModelAndView("flight_New");
		return modelAndView;
	}

	@RequestMapping(value = "insert_flight", method = RequestMethod.POST)
	public ModelAndView insert_flight(
			@ModelAttribute("flightBean") @Valid FlightBean flightBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("flight_New");
			System.out.println("error");
		} else {
			String addResult = administratorService.addFlight(flightBean);
			if (addResult.equals("success")) {
				modelAndView = new ModelAndView("Success_Admin");
				modelAndView.addObject("message", "Successfully Inserted");
				System.out.println("inserted");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message",
						"Failed to create new schedule");
				System.out.println("failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "del_flight", method = RequestMethod.GET)
	public ModelAndView del_flight(
			@ModelAttribute("flightBean") FlightBean flightBean) {
		ArrayList<FlightBean> flightId = administratorService.fetchFlightId();
		ModelAndView modelAndView = new ModelAndView("flight_Delete");
		modelAndView.addObject("flightIdlist", flightId);
		return modelAndView;
	}

	@RequestMapping(value = "delete_flight", method = RequestMethod.POST)
	public ModelAndView delete_flight(
			@ModelAttribute("flightBean") @Valid FlightBean flightBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("del_flight");
			System.out.println("error");
		} else {
			ArrayList<String> ar = new ArrayList<String>();
			ar.add(flightBean.getFlightID());
			int removeResult = administratorService.removeFlight(ar);
			if (removeResult == 1) {
				modelAndView = new ModelAndView("Success_Admin");
				modelAndView.addObject("message", "Successfully Deleted");
				System.out.println("deleted");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failed Delete Flight");
				System.out.println("failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "view_flight", method = RequestMethod.GET)
	public ModelAndView view_flight(
			@ModelAttribute("flightBean") @Valid FlightBean flightBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("flight");
			System.out.println("error");
		} else {
			ArrayList<FlightBean> ar = administratorService.viewByAllFlights();
			if (ar.size() != 0) {
				modelAndView = new ModelAndView("flight_View");
				modelAndView.addObject("message", ar);
				System.out.println("view success");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failed to view Flight");
				System.out.println("view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "vwById_flight", method = RequestMethod.GET)
	public ModelAndView vw_flight(
			@ModelAttribute("flightBean") FlightBean flightBean) {
		ArrayList<FlightBean> flightId = administratorService.fetchFlightId();
		ModelAndView modelAndView = new ModelAndView("flight_ViewById");
		modelAndView.addObject("flightIdlist", flightId);
		return modelAndView;
	}

	@RequestMapping(value = "viewById_flight", method = RequestMethod.POST)
	public ModelAndView viewById_flight(
			@ModelAttribute("flightBean") @Valid FlightBean flightBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("flight_viewById");
			System.out.println("error");
		} else {
			String id = flightBean.getFlightID();
			FlightBean obj = administratorService.viewByFlightId(id);
			if (obj != null) {
				modelAndView = new ModelAndView("Display");
				modelAndView.addObject("message", obj);
				System.out.println("view success");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failed to view Flight");
				System.out.println("view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "upd_flight", method = RequestMethod.GET)
	public ModelAndView upd_flight(
			@ModelAttribute("flightBean") FlightBean flightBean) {
		ArrayList<FlightBean> flightId = administratorService.fetchFlightId();
		ModelAndView modelAndView = new ModelAndView("flight_Update");
		modelAndView.addObject("flightIdlist", flightId);
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("flightBean") @Valid FlightBean flightBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("flight_Update");
			System.out.println("error");
		} else {
			String id = flightBean.getFlightID();
			FlightBean obj = administratorService.viewByFlightId(id);
			if (obj != null) {
				modelAndView = new ModelAndView("flight_UpdatePage");
				modelAndView.addObject("message",
						"Please Modify the Fields if You want!");
				modelAndView.addObject("viewResult", obj);
				System.out.println("view success");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failed to view Flight");
				System.out.println("view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public ModelAndView modify(
			@ModelAttribute("flightBean") @Valid FlightBean flightBean,
			BindingResult result) {

		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("flight_UpdatePage");
			System.out.println("Error");
		} else {
			boolean resultData = administratorService.modifyFlight(flightBean);
			System.out.println(resultData);
			if (resultData == true) {
				modelAndView = new ModelAndView("Success_Admin");
				modelAndView.addObject("message", "Successfully Modified ");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failure");
			}

		}
		return modelAndView;

	}

	@RequestMapping(value = "pay", method = RequestMethod.GET)
	public ModelAndView pay(
			@ModelAttribute("paymentBean") PaymentBean paymentBean) {
		ModelAndView modelAndView = new ModelAndView("payment");
		System.out.println(modelAndView);
		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public ModelAndView payment(
			@ModelAttribute("paymentBean") @Valid PaymentBean paymentBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("payment");
			System.out.println(result);
		} else {
			ArrayList<PaymentBean> searchRes = administratorService
					.payment(paymentBean);
			Iterator it = searchRes.iterator();
			if (it.hasNext()) {
				modelAndView = new ModelAndView("Success_Admin");
				modelAndView.addObject("message", "Success");
				System.out.println("Available");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Sorry.Invalid Entry..");
				System.out.println("failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "home1")
	public ModelAndView home(@ModelAttribute("routeBean") RouteBean routeBean) {
		ModelAndView modelAndView = new ModelAndView("route_start");
		return modelAndView;
	}

	@RequestMapping(value = "new_route", method = RequestMethod.GET)
	public ModelAndView new_route(
			@ModelAttribute("routeBean") RouteBean routeBean) {
		ModelAndView modelAndView = new ModelAndView("Route_New");
		return modelAndView;
	}

	@RequestMapping(value = "manage_route")
	public ModelAndView manage_route(
			@ModelAttribute("flightBean") FlightBean flightBean) {
		ModelAndView modelAndView = new ModelAndView("Route");
		return modelAndView;
	}

	@RequestMapping(value = "insert_route", method = RequestMethod.POST)
	public ModelAndView insert_route(
			@ModelAttribute("routeBean") @Valid RouteBean routeBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Route_New");
			System.out.println("error");
		} else {
			System.out.println("Hello");

			String addResult = administratorService.addRoute(routeBean);

			if (addResult.equals("success")) {
				modelAndView = new ModelAndView("Success_Route");
				modelAndView.addObject("message", "Success");
				System.out.println("inserted");
			} else {
				modelAndView = new ModelAndView("Failure_Route");
				modelAndView.addObject("message", "Failed to create new route");
				System.out.println("failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "view_route", method = RequestMethod.GET)
	public ModelAndView view_route(
			@ModelAttribute("routeBean") @Valid RouteBean routeBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Route");
			System.out.println(result);
		} else {
			ArrayList<RouteBean> ar = administratorService.viewByAllRoute();
			if (ar.size() != 0) {
				modelAndView = new ModelAndView("Route_view");
				modelAndView.addObject("message", ar);
				System.out.println("view success");
			} else {
				modelAndView = new ModelAndView("Failure_Route");
				modelAndView.addObject("message", "Failed to view Route");
				System.out.println("view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "del_route", method = RequestMethod.GET)
	public ModelAndView del_route(
			@ModelAttribute("routeBean") RouteBean routeBean) {
		ArrayList<RouteBean> routeId = administratorService.fetchRouteId();
		ModelAndView modelAndView = new ModelAndView("Delete_Route");
		modelAndView.addObject("routeIdlist", routeId);
		return modelAndView;
	}

	@RequestMapping(value = "delete_route", method = RequestMethod.POST)
	public ModelAndView delete_route(
			@ModelAttribute("routeBean") @Valid RouteBean routeBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Delete_Route");
			System.out.println("error");
		} else {
			ArrayList<String> ar = new ArrayList<String>();
			ar.add(routeBean.getRouteID());
			System.out.println(ar.get(0));
			int removeResult = administratorService.removeRoute(ar);
			if (removeResult == 1) {
				modelAndView = new ModelAndView("Success_Route");
				modelAndView.addObject("message", "Successfully Deleted");
				System.out.println("deleted");
			} else {
				modelAndView = new ModelAndView("Failure_Route");
				modelAndView.addObject("message", "Failed Delete Route");
				System.out.println("failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "viewById_route", method = RequestMethod.GET)
	public ModelAndView vw_route(
			@ModelAttribute("routeBean") RouteBean routeBean) {
		ArrayList<RouteBean> routeId = administratorService.fetchRouteId();
		ModelAndView modelAndView = new ModelAndView("Route_viewbyid");
		modelAndView.addObject("routeIdlist", routeId);
		return modelAndView;
	}

	@RequestMapping(value = "viewId_route", method = RequestMethod.POST)
	public ModelAndView viewById_route(
			@ModelAttribute("routeBean") @Valid RouteBean routeBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Route_viewbyid");
			System.out.println("error");
		} else {
			String id = routeBean.getRouteID();
			RouteBean obj = administratorService.viewByRouteId(id);
			System.out.println(obj.getRouteID());
			if (obj != null) {
				modelAndView = new ModelAndView("Display_Route");
				modelAndView.addObject("message", obj);
				System.out.println("view success");
			} else {
				modelAndView = new ModelAndView("Failure_Route");
				modelAndView.addObject("message", "Failed to view Route");
				System.out.println("view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "upd_route", method = RequestMethod.GET)
	public ModelAndView upd_route(
			@ModelAttribute("routeBean") RouteBean routeBean) {
		ArrayList<RouteBean> routeId = administratorService.fetchRouteId();
		ModelAndView modelAndView = new ModelAndView("Route_update");
		modelAndView.addObject("routeIdlist", routeId);
		return modelAndView;
	}

	@RequestMapping(value = "update_Route", method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("routeBean") @Valid RouteBean routeBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Route_update");
			System.out.println("error");
		} else {
			String id = routeBean.getRouteID();
			RouteBean obj = administratorService.viewByRouteId(id);
			if (obj != null) {
				modelAndView = new ModelAndView("Route_updatepage");
				modelAndView.addObject("message",
						"Please Modify the Fields if You want!");
				modelAndView.addObject("viewResult", obj);
				System.out.println("view success");
			} else {
				modelAndView = new ModelAndView("Failure_Route");
				modelAndView.addObject("message", "Failed to view Route");
				System.out.println("view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "modify_Route", method = RequestMethod.POST)
	public ModelAndView modify(
			@ModelAttribute("routeBean") @Valid RouteBean routeBean,
			BindingResult result) {

		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("Route_updatepage");
			System.out.println("Error");
		} else {
			boolean resultData = administratorService.modifyRoute(routeBean);
			System.out.println(resultData);
			if (resultData == true) {
				modelAndView = new ModelAndView("Success_Route");
				modelAndView.addObject("message", "Successfully Modified ");
			} else {
				modelAndView = new ModelAndView("Failure_Route");
				modelAndView.addObject("message", "Failure");
			}

		}
		return modelAndView;

	}

	@RequestMapping(value = "home2")
	public ModelAndView home(
			@ModelAttribute("scheduleBean") ScheduleBean scheduleBean) {
		ModelAndView modelAndView = new ModelAndView("schedule");
		return modelAndView;
	}

	@RequestMapping(value = "new_schedule", method = RequestMethod.GET)
	public ModelAndView new_schedule(
			@ModelAttribute("scheduleBean") ScheduleBean scheduleBean) {
		ArrayList<FlightBean> flist = administratorService.fetchFlightId();
		ArrayList<RouteBean> rlist = administratorService.fetchRouteId();
		ModelAndView modelAndView = new ModelAndView("schedule_New");
		modelAndView.addObject("listf", flist);
		modelAndView.addObject("listr", rlist);
		return modelAndView;
	}

	@RequestMapping(value = "insert_schedule", method = RequestMethod.POST)
	public ModelAndView insert_schedule(
			@ModelAttribute("scheduleBean") @Valid ScheduleBean scheduleBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			ArrayList<FlightBean> flist = administratorService.fetchFlightId();
			ArrayList<RouteBean> rlist = administratorService.fetchRouteId();
			modelAndView = new ModelAndView("schedule_New");
			modelAndView.addObject("listf", flist);
			modelAndView.addObject("listr", rlist);
		} else {
			String addResult = administratorService.addSchedule(scheduleBean);
			if (addResult.equals("success")) {
				modelAndView = new ModelAndView("schedule_Manage");
				// modelAndView.addObject("message", "Success");
			} else {
				modelAndView = new ModelAndView("failure_schedule");
				modelAndView.addObject("message",
						"Failed to create new schedule");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "manage_schedule", method = RequestMethod.GET)
	public ModelAndView manage_schedule(
			@ModelAttribute("scheduleBean") ScheduleBean scheduleBean) {
		ModelAndView modelAndView = new ModelAndView("schedule_Manage");
		return modelAndView;
	}

	@RequestMapping(value = "delete_schedule", method = RequestMethod.GET)
	public ModelAndView delete_schedule(
			@ModelAttribute("scheduleBean") ScheduleBean scheduleBean) {
		ArrayList<ScheduleBean> slist = administratorService.fetchScheduleID();
		ModelAndView modelAndView = new ModelAndView("schedule_delete");
		modelAndView.addObject("lists", slist);
		return modelAndView;
	}

	@RequestMapping(value = "d_schedule", method = RequestMethod.POST)
	public ModelAndView d_schedule(
			@ModelAttribute("scheduleBean") @Valid ScheduleBean scheduleBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			ArrayList<ScheduleBean> slist = administratorService
					.fetchScheduleID();
			modelAndView = new ModelAndView("schedule_delete");
			modelAndView.addObject("lists", slist);
			System.out.println(result);
		} else {
			ArrayList<String> sbList = new ArrayList<String>();
			sbList.add(scheduleBean.getScheduleID());
			int removeResult = administratorService.removeSchedule(sbList);
			if (removeResult == 1) {
				modelAndView = new ModelAndView("success_schedule");
				modelAndView.addObject("message", "Deleted");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failed to delete schedule");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "viewby_scheduleID", method = RequestMethod.GET)
	public ModelAndView viewbyID(
			@ModelAttribute("scheduleBean") ScheduleBean scheduleBean) {
		ArrayList<ScheduleBean> slist = administratorService.fetchScheduleID();
		ModelAndView modelAndView = new ModelAndView("schedule_viewByID");
		modelAndView.addObject("lists", slist);
		return modelAndView;
	}

	@RequestMapping(value = "vid_schedule", method = RequestMethod.POST)
	public ModelAndView vid_schedule(
			@ModelAttribute("scheduleBean") @Valid ScheduleBean scheduleBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			ArrayList<ScheduleBean> slist = administratorService
					.fetchScheduleID();
			modelAndView = new ModelAndView("schedule_viewByID");
			modelAndView.addObject("lists", slist);
			System.out.println(result);
		} else {
			String sid = scheduleBean.getScheduleID();
			ScheduleBean sbean = administratorService.viewByScheduleId(sid);
			if (sbean != null) {
				modelAndView = new ModelAndView("schedule_display");
				modelAndView.addObject("schedule", sbean);
			} else {
				modelAndView = new ModelAndView("failure_schedule");
				modelAndView.addObject("message", "this view failed");
			}
		}
		return modelAndView;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "viewAll_schedule", method = RequestMethod.GET)
	public ModelAndView v_schedule(
			@ModelAttribute("scheduleBean") @Valid ScheduleBean scheduleBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("schedule_Manage");
			System.out.println(result);
		} else {
			ArrayList<ScheduleBean> s_array = administratorService
					.viewByAllSchedule();
			if (s_array.size() != 0) {
				Iterator itr = s_array.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
				modelAndView = new ModelAndView("schedule_viewAll");
				modelAndView.addObject("schedule", s_array);
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "this view failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "edit_schedule", method = RequestMethod.GET)
	public ModelAndView edit_schedule(
			@ModelAttribute("scheduleBean") ScheduleBean scheduleBean) {
		ArrayList<ScheduleBean> slist = administratorService.fetchScheduleID();
		ModelAndView modelAndView = new ModelAndView("schedule_update");
		modelAndView.addObject("schedIdlist", slist);
		return modelAndView;
	}

	@RequestMapping(value = "u_schedule", method = RequestMethod.POST)
	public ModelAndView u_schedule(
			@ModelAttribute("scheduleBean") @Valid ScheduleBean scheduleBean,
			BindingResult result) {
		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			ArrayList<ScheduleBean> slist = administratorService
					.fetchScheduleID();
			modelAndView = new ModelAndView("schedule_update");
			modelAndView.addObject("schedIdlist", slist);
		} else {
			String id = scheduleBean.getScheduleID();
			ScheduleBean sbean = administratorService.viewByScheduleId(id);
			if (sbean != null) {
				modelAndView = new ModelAndView("schedule_updatepage");
				modelAndView.addObject("viewResult", sbean);
				modelAndView.addObject("message",
						"Modify the Fields which You want!");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "update failed");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "modify_schedule", method = RequestMethod.POST)
	public ModelAndView modify(
			@ModelAttribute("scheduleBean") @Valid ScheduleBean scheduleBean,
			BindingResult result) {

		ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("schedule_updatepage");
			System.out.println("Error");
		} else {
			boolean resultData = administratorService
					.modifySchedule(scheduleBean);
			System.out.println(resultData);
			if (resultData == true) {
				modelAndView = new ModelAndView("success_schedule");
				modelAndView.addObject("message", "Successfully Modified ");
			} else {
				modelAndView = new ModelAndView("Failure");
				modelAndView.addObject("message", "Failure");
			}

		}
		return modelAndView;

	}

	@RequestMapping(value = "changepwd", method = RequestMethod.GET)
	public ModelAndView changePassword(
			@ModelAttribute("credentialsBean") CredentialsBean credentialsBean) {

		ModelAndView modelAndView = new ModelAndView("ChangePassword");

		return modelAndView;

	}

	@RequestMapping(value = "success", method = RequestMethod.POST)
	public ModelAndView success(
			@ModelAttribute("credentialsBean") @Valid CredentialsBean credentialsBean,
			BindingResult result, HttpSession session,
			HttpServletRequest request) {
		ModelAndView modelAndView = null;

		String newPassword = request.getParameter("newPwd");
		// String oldPassword = request.getParameter("oldPwd");
		String sid = request.getParameter("sid");

		credentialsBean.setUserID(session.getAttribute("userId").toString());
		// credentialsBean.setPassword(oldPassword);

		String logResult = administratorService.changePassword(credentialsBean,
				newPassword);

		if (logResult.equals(null)) {
			modelAndView = new ModelAndView("ChangePassword");
			return modelAndView;
		}

		else if (logResult == "SUCCESS") {
			modelAndView = new ModelAndView("Success_Admin");
		} else {
			modelAndView = new ModelAndView("Failure");
		}

		return modelAndView;
	}

	@RequestMapping(value = "viewticket", method = RequestMethod.GET)
	public ModelAndView viewTicket(
			@ModelAttribute("reservationBean") ReservationBean reservationBean) {
		ArrayList<ReservationBean> rlist = administratorService
				.fetchReservationId();
		ModelAndView modelAndView = new ModelAndView("ViewTicket");
		modelAndView.addObject("rlist", rlist);
		return modelAndView;

	}

	@RequestMapping(value = "viewticket2", method = RequestMethod.GET)
	public ModelAndView viewTicket2(
			@ModelAttribute("reservationBean") ReservationBean reservationBean) {

		ModelAndView modelAndView = new ModelAndView("ViewTicket2");

		return modelAndView;

	}

	@RequestMapping(value = "viewTicketSuccess2", method = RequestMethod.POST)
	public ModelAndView viewTicketSuccess2(
			@ModelAttribute("reservationBean") ReservationBean reservationBean,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("ShowTicket");

		String reservationId = reservationBean.getReservationid();

		Map<ReservationBean, PassengerBean> mapResult = customerService
				.viewTicket(reservationId);

		if (mapResult == null) {

			modelAndView = new ModelAndView("ViewTicket2");

			return modelAndView;
		} else {

			session.setAttribute("mapResult", mapResult);

			modelAndView = new ModelAndView("ShowTicket2");

		}

		return modelAndView;

	}

	@RequestMapping(value = "viewTicketSuccess", method = RequestMethod.POST)
	public ModelAndView viewTicketSuccess(
			@ModelAttribute("reservationBean") ReservationBean reservationBean,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView("ShowTicket");

		String reservationId = reservationBean.getReservationid();

		Map<ReservationBean, PassengerBean> mapResult = customerService
				.viewTicket(reservationId);

		if (mapResult == null) {

			ArrayList<ReservationBean> rlist = administratorService
					.fetchReservationId();
			modelAndView = new ModelAndView("ViewTicket");
			modelAndView.addObject("rlist", rlist);
			return modelAndView;
		} else {

			session.setAttribute("mapResult", mapResult);

			modelAndView = new ModelAndView("ShowTicket");

		}

		return modelAndView;

	}
}
