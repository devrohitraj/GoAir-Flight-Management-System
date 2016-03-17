package com.raj.frs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raj.frs.bean.FlightBean;

@Repository
@Transactional
public class FlightDAOImpl implements FlightDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String findSequence() {

		String flight_seq = "FRS_SEQ_FLIGHT_ID";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
				
		SQLQuery query=session.createSQLQuery("select "+flight_seq+".nextval from dual");
		
		List list=query.list();
		BigDecimal big=(BigDecimal)list.get(0);
		
		
		return String.valueOf(big);
	}

	@Override
	public String createFlight(FlightBean flight) {

		
		try{
			String sequence = findSequence();
			sequence = flight.getFlightName().substring(0, 2).toUpperCase()+sequence;
			flight.setFlightID(sequence);
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(flight);
			tx.commit();
			}catch(HibernateException he){
				return "FAIL";
			}catch(Exception e){
				return "ERROR";
			}
			return "SUCCESS";

	}

	@Override
	public int deleteFlight(ArrayList<String> flightID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateFlight(FlightBean flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FlightBean findByID(String flightID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FlightBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
