package com.raj.frs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ReservationBean;

@Repository
@Transactional
public class PassengerDAOImpl implements PassengerDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	PassengerBean passenger;

	/*@Override
	public String findSequence() {
		
		
		String passenger_seq = "FRS_SEQ__ID";//define Passenger seq here
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
				
		SQLQuery query=session.createSQLQuery("select "+passenger_seq+".nextval from dual");
		
		List list=query.list();
		BigDecimal big=(BigDecimal)list.get(0);
		int seq=big.intValue();
		
		
		return String.valueOf(seq);
	}*/

	@Override
	public String createPassenger(PassengerBean passenger) {
		try{
			
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(passenger);
			tx.commit();
			}catch(HibernateException he){
				return "FAIL";
			}catch(Exception e){
				return "ERROR";
			}
			return "SUCCESS";
	}

	@Override
	public int deletePassenger(ArrayList<PassengerBean> idList) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			for(PassengerBean id :idList){
				session.delete(id.getReservationID());
			}
			
			tx.commit();
			
			}catch(HibernateException e){
				return 0;
			}
			return 1;
	}

	@Override
	public boolean updatePassenger(PassengerBean passenger) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.update(passenger);
			
			tx.commit();
			
			}catch(HibernateException e){
				return false;
			}
			return true;
	}

	@Override
	public PassengerBean findByID(String ID) {
		try{
			Session session=sessionFactory.openSession();
			org.hibernate.Transaction tx=session.beginTransaction();
			passenger = (PassengerBean)session.get(PassengerBean.class, ID);
			
			}catch(HibernateException he){
				return null;
			}
		
		// TODO Auto-generated method stub
		return passenger;
	}

	@Override
	public ArrayList<PassengerBean> findAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("from PassengerBean");
		
		tx.commit();
		//session.close();
		
		@SuppressWarnings("unchecked")
		ArrayList<PassengerBean> list=(ArrayList<PassengerBean>) query.list();
		
		if(list.isEmpty())
		{
			return null;
		}
		
		return list;
	}

}
