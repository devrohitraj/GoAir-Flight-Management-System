package com.raj.frs.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CreditCardDAOImpl implements CreditCardDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean checkPayment(String userID, String cardNumber, Date validFrom, Date ValidTo, String pin,
			double fare) {
		// TODO Auto-generated method stub
		return false;
	}

}
