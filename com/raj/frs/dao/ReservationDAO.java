
package com.raj.frs.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ReservationBean;



public interface ReservationDAO {
	
	
	String createReservation(ReservationBean reservation);
	
	int deleteReservation(ArrayList<String> idList);
	
	boolean updateReservation(ReservationBean reservation);
	
	boolean updateReservation(String userID, int status);
	
	ReservationBean findByID(String ID);
	
	ArrayList<ReservationBean> findAll();
	
	String findSequence();
	
	String reserveTicket(ReservationBean reservationBean,ArrayList<PassengerBean> passengers);
}
