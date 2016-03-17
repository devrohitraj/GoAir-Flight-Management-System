
package com.raj.frs.dao;

import com.raj.frs.bean.ProfileBean;
import com.raj.frs.bean.ReservationBean;


public interface ProfileDAO {

	String findSequence();
	String createUser(ProfileBean profilebean);
	
}
