
package com.raj.frs.dao;

import java.util.ArrayList;

import com.raj.frs.bean.FlightBean;
import com.raj.frs.bean.RouteBean;



public interface FlightDAO {
String findSequence();
	
	String createFlight(FlightBean flight);

	int deleteFlight(ArrayList<String> flightID);

	boolean updateFlight(FlightBean flight);

	FlightBean findByID(String flightID);

	ArrayList<FlightBean> findAll();
}
