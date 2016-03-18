package com.raj.frs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ReservationBean;
import com.raj.frs.bean.ScheduleBean;
import com.raj.frs.util.User;

public interface Customer{
	ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date);

	String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers);

	boolean cancelTicket(String reservationId);

	Map<ReservationBean,PassengerBean> viewTicket(String reservationId);

	Map<ReservationBean,PassengerBean> printTicket(String reservationId);
}
