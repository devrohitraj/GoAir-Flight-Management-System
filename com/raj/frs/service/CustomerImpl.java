package com.raj.frs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ProfileBean;
import com.raj.frs.bean.ReservationBean;
import com.raj.frs.bean.ScheduleBean;

import com.raj.frs.dao.PassengerDAO;

import com.raj.frs.dao.ReservationDAO;

import com.raj.frs.dao.RouteDAO;

@Service
@Repository
public class CustomerImpl implements Customer{
	@Autowired
	private ReservationDAO reservationBeanDAO;
	@Autowired
	private PassengerDAO passengerBeanDAO;
	@Autowired
	private RouteDAO routeBeanDAO;
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date)
	{
		return null;
		
	}
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers)
	{
		return null;
		
	}
	@Override
	public boolean cancelTicket(String reservationId) {
		/*// TODO Auto-generated method stub
		int b=reservationBeanDAO.deleteReservation(reservationId);
		if(b==1)
		{
		return true;
		}
		else*/
			return false;
	}
	@Override
	public Map<ReservationBean, PassengerBean> viewTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<ReservationBean, PassengerBean> printTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
