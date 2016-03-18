package com.raj.frs.service;

import java.util.ArrayList;

import com.raj.frs.bean.FlightBean;
import com.raj.frs.bean.RouteBean;
import com.raj.frs.bean.ScheduleBean;
import com.raj.frs.util.User;

public interface Administrator{
	
	String addFlight(FlightBean flightBean);
	
	boolean modifyFlight(FlightBean flightBean);

	int removeFlight(ArrayList<String> flightID);
	
	

	String addSchedule(ScheduleBean scheduleBean);

	boolean modifySchedule(ScheduleBean scheduleBean);

	int removeSchedule(ArrayList<String> scheduleId);

	String addRoute(RouteBean routeBean);

	boolean modifyRoute(RouteBean routeBean);

	int removeRoute(ArrayList<String> routeId);
}
