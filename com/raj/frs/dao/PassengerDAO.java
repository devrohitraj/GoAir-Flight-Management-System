
package com.raj.frs.dao;

import java.util.ArrayList;




import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ScheduleBean;


public interface PassengerDAO {

	
	
	
	String createPassenger(PassengerBean passenger);

	int deletePassenger(ArrayList<PassengerBean> idList);

	boolean updatePassenger(PassengerBean passenger);

	PassengerBean findByID(String ID);

	
	ArrayList<PassengerBean> findAll();
}
