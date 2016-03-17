package com.raj.frs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.raj.frs.bean.RouteBean;
import com.raj.frs.bean.ScheduleBean;

@Repository
@Transactional
public class ScheduleDAOImpl implements ScheduleDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ScheduleBean scheduleBean;

	@Override
	public String findSequence() {
		
		
		String schedule_seq = "FRS_SEQ_SCHEDULE_ID";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
				
		SQLQuery query=session.createSQLQuery("select "+schedule_seq+".nextval from dual");
		
		List list=query.list();
		BigDecimal big=(BigDecimal)list.get(0);
		int seq=big.intValue();
		
		
		return String.valueOf(seq);
	}

	@Override
	public String createSchedule(ScheduleBean scheduleBean) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(scheduleBean);
			tx.commit();
			}catch(HibernateException he){
				return "FAIL";
			}catch(Exception e){
				return "ERROR";
			}
			return "SUCCESS";
	}

	@Override
	public int deleteSchedule(ArrayList<String> scheduleID) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			for(String id :scheduleID){
				session.delete(id);
			}
			
			tx.commit();
			
			}catch(HibernateException e){
				return 0;
			}
			return 1;
	}

	@Override
	public boolean updateSchedule(ScheduleBean scheduleBean) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.update(scheduleBean);
			
			tx.commit();
			
			}catch(HibernateException e){
				return false;
			}
			return true;
	}

	@Override
	public ScheduleBean findByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RouteBean findByIDRoute(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date) {

		ArrayList<ScheduleBean> scheduleBeans1 = new ArrayList<ScheduleBean>();

		try{
		String hql = "Select R.routeID FROM RouteBean R WHERE R.source = :source AND R.destination = :destination";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("source",source);
		query.setParameter("destination", destination);
		List<String> routeids =(ArrayList<String>) query.list();
		
		
		String hql1 = "Select S.scheduleID FROM ScheduleBean S WHERE S.routeID = :routeID";
		ArrayList<String> scheduleid = new ArrayList<String>();
		Query query1 = session.createQuery(hql1);
		for(String route_id: routeids){
		query1.setParameter("routeID",route_id);
		List schedule_id =(ArrayList<String>) query1.list();
		
		scheduleid.add((String) schedule_id.get(0));
		}
		
		
		String hql2 = "Select R.scheduleID FROM ReservationBean R WHERE R.scheduleID = :scheduleID AND R.journeyDate = :date";
		Query query2 = session.createQuery(hql2);
		ArrayList<String> scheduleid1 = new ArrayList<String>();
		for(String schedule_id1: scheduleid){
		query.setParameter("scheduleID",schedule_id1);
		query.setParameter("date", date);
		List<String> routeids1 =(ArrayList<String>) query2.list();
		scheduleid1.add(routeids1.get(0));
		}
		
		for(String scheduleID : scheduleid1){
		
			
		scheduleBean = (ScheduleBean)session.get(ScheduleBean.class, scheduleID);
		scheduleBeans1.add(scheduleBean);
		
		}
			
			}catch(HibernateException he){
				return null;
			}
		
		
		return scheduleBeans1;
	}
	
	

}
