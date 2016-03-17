
package com.raj.frs.dao;

import java.util.ArrayList;
import java.util.Date;

import com.raj.frs.bean.RouteBean;
import com.raj.frs.bean.ScheduleBean;


public interface ScheduleDAO {
String findSequence();
	
	String createSchedule(ScheduleBean scheduleBean);

	int deleteSchedule(ArrayList<String> scheduleID);

	boolean updateSchedule(ScheduleBean scheduleBean);

	ScheduleBean findByID(String ID);
	
	 RouteBean findByIDRoute(String ID);

	ArrayList<ScheduleBean> viewByAllSchedule();

	ArrayList<ScheduleBean> viewScheduleByRoute(String source,
			String destination, Date date);
}
