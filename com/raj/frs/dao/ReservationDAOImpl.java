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

import com.raj.frs.bean.PassengerBean;
import com.raj.frs.bean.ReservationBean;

@Repository
@Transactional
public class ReservationDAOImpl implements ReservationDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ReservationBean reservationbean;
	
	
	@Override
	public String findSequence() {


		String reservation_seq = "FRS_SEQ_RESERVATION_ID";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
				
		SQLQuery query=session.createSQLQuery("select "+reservation_seq+".nextval from dual");
		
		List list=query.list();
		BigDecimal big=(BigDecimal)list.get(0);
		int seq=big.intValue();
		
		
		return String.valueOf(seq);
		
	}

	@Override
	public String createReservation(ReservationBean reservation) {
		
		try{
		String sequence = findSequence();
		sequence = reservation.getReservationType().substring(0, 1).toUpperCase()+sequence;
		reservation.setReservationID(sequence);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(reservation);
		tx.commit();
		}catch(HibernateException he){
			return "FAIL";
		}catch(Exception e){
			return "ERROR";
		}
		return "SUCCESS";
	}

	@Override
	public int deleteReservation(ArrayList<String> idList) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			for(String id :idList){
				session.delete(id);
			}
			
			tx.commit();
			
			}catch(HibernateException e){
				return 0;
			}
			return 1;
	}

	@Override
	public boolean updateReservation(ReservationBean reservation) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.update(reservation);
			
			tx.commit();
			
			}catch(HibernateException e){
				return false;
			}
			return true;
	}

	@Override
	public boolean updateReservation(String userID, int status) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			reservationbean = (ReservationBean)session.get(ReservationBean.class, userID);
			reservationbean.setBookingStatus(status);
			tx.commit();
			session.update(reservationbean);
			}catch(HibernateException he){
				return false;
			}
			
			// TODO Auto-generated method stub
			return true;
	}

	@Override
	public ReservationBean findByID(String ID) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			reservationbean = (ReservationBean)session.get(ReservationBean.class, ID);
			
			}catch(HibernateException he){
				return null;
			}
		
		// TODO Auto-generated method stub
		return reservationbean;
	}

	@Override
	public ArrayList<ReservationBean> findAll() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("from ReservationBean");
		
		tx.commit();
		//session.close();
		
		@SuppressWarnings("unchecked")
		ArrayList<ReservationBean> list=(ArrayList<ReservationBean>) query.list();
		
		if(list.isEmpty())
		{
			return null;
		}
		
		return list;
	}

	

	@Override
	public String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers) {
		// TODO Auto-generated method stub
		return null;
	}

}
