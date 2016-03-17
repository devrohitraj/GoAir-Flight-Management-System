
package com.wipro.frs.dao;

import java.util.ArrayList;

import com.raj.frs.bean.RouteBean;


public interface RouteDAO {

	String findSequence();
	
	String createRoute(RouteBean route);

	int deleteRoute(ArrayList<String> IDList);

	boolean updateRoute(RouteBean route);

	RouteBean findByID(String ID);

	ArrayList<RouteBean> viewByAllRoute();
	
	public String findRoute(String source,String destination);
	

}
