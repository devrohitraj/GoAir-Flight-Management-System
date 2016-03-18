package com.raj.frs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.FlightBean;
import com.raj.frs.bean.ProfileBean;
import com.raj.frs.bean.RouteBean;
import com.raj.frs.bean.ScheduleBean;

import com.raj.frs.dao.FlightDAO;

import com.raj.frs.dao.RouteDAO;

import com.raj.frs.dao.ScheduleDAO;
import com.raj.frs.util.UserImpl;

@Service
@Transactional
public class AdministratorImpl implements Administrator{
	@Autowired 
	private FlightDAO flightDAO;
	@Autowired 
	private ScheduleDAO scheduleDAO;
	@Autowired
	private RouteDAO routeDAO;
	@Autowired 
	private RouteBean  routeBean ;
	@Autowired
	UserImpl userimpl;
	
	
	public String addFlight(FlightBean flightBean)
	{
		if(flightBean!=null)
		{
		String seq=flightDAO.findSequence();
		String s1=flightBean.getFlightName().substring(0,2)+seq;
		flightBean.setFlightID(s1);
		String s=flightDAO.createFlight(flightBean);
		if(s.equalsIgnoreCase("SUCCESS"))
		{
		return s;}
		else if(s.equalsIgnoreCase("FAIL"))
		{
		return s;
		}
		
	}
		return "ERROR";
	}
public boolean modifyFlight(FlightBean flightBean)
	{
		boolean b=flightDAO.updateFlight(flightBean);
		if(b)
		return true;
		else
		{
			return false;
		}
		
	}
	public int removeFlight(ArrayList<String> flightID)
	{
		int i=flightDAO.deleteFlight(flightID);
		
			return i;
		
	}
	public String addSchedule(ScheduleBean scheduleBean)
	{
		String result="SUCCESS";
		if(scheduleBean!=null)
{
	String seq=scheduleDAO.findSequence();
    routeBean= scheduleDAO.findByIDRoute(scheduleBean.getRouteID());
	String seq1 =routeBean.getSource().substring(0, 2).toUpperCase()+routeBean.getDestination().substring(0, 2)
			.toUpperCase();
	
	scheduleBean.setScheduleID(seq1+seq);
	result=scheduleDAO.createSchedule(scheduleBean);
	}
		
		return result;
	}
	public boolean modifySchedule(ScheduleBean scheduleBean)
	{
		boolean b=scheduleDAO.updateSchedule(scheduleBean);
		if(b)
		{
			return true;
		}
		return false;
		
	}
	public int removeSchedule(ArrayList<String> scheduleId)
	{
		int i=scheduleDAO.deleteSchedule(scheduleId);
		
			return i;
		
	}

	public String addRoute(RouteBean routeBean)
	{
		
		if(routeBean==null)
		{
		String seq=routeDAO.findSequence();
		String s1=routeBean.getSource().substring(0, 2)+routeBean.getDestination().substring(0, 2)+seq;
		if(routeBean.getSource()!=routeBean.getDestination())
		{
			
		String s3=routeDAO.createRoute(routeBean);
	return s3;
		}
		}
		return "FAIL";
	}

	public boolean modifyRoute(RouteBean routeBean)
	{
		boolean b=routeDAO.updateRoute(routeBean);
		if(b)
		return true;
		else
		{
			return false;
		}
		
	}

	public int removeRoute(ArrayList<String> routeId)
	{
		int i=routeDAO.deleteRoute(routeId);
		if(i==1)
		{
		return 1;
		}
		else
			return 0;
		
	}
	/*@Override
	public String login(CredentialsBean credentialsBean) {
		if(credentialsBean == null){
			return "FAIL";
		}
		
		return userimpl.login(credentialsBean);
	}
	@Override
	public String register(ProfileBean profileBean) {
		if(profileBean == null){
			
		}
		
		return userimpl.register(profileBean);
	}
	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {


		if(credentialsBean == null || newPassword == null || newPassword.equals("")){
			return null;
		}
		
		return userimpl.changePassword(credentialsBean, newPassword);
	}
	@Override
	public boolean logout(String userId) {
		if(userId == null||userId.equals("")){
			return false;
		}
		return userimpl.logout(userId);
	}*/
}
