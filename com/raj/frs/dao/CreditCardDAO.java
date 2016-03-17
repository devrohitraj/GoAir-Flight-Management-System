package com.raj.frs.dao;

import java.util.Date;

public interface CreditCardDAO {

	
	boolean checkPayment(String userID,String cardNumber,Date validFrom,Date ValidTo,String pin,double fare);
}
