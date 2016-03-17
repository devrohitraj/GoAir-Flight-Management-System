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

import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.RouteBean;

@Repository
@Transactional
public class RouteDAOImpl implements RouteDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	RouteBean routebean;

	@Override
	public String findSequence() {
		
		
		String route_seq = "FRS_SEQ_ROUTE_ID";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
				
		SQLQuery query=session.createSQLQuery("select "+route_seq+".nextval from dual");
		
		List list=query.list();
		BigDecimal big=(BigDecimal)list.get(0);
		int seq=big.intValue();
		
		return String.valueOf(seq);
	}

	@Override
	public String createRoute(RouteBean route) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(route);
			tx.commit();
			}catch(HibernateException he){
				return "FAIL";
			}catch(Exception e){
				return "ERROR";
			}
			return "SUCCESS";
	}

	@Override
	public int deleteRoute(ArrayList<String> IDList) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			for(String id :IDList){
				session.delete(id);
			}
			
			tx.commit();
			
			}catch(HibernateException e){
				return 0;
			}
			return 1;
	}

	@Override
	public boolean updateRoute(RouteBean route) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.update(route);
			
			tx.commit();
			
			}catch(HibernateException e){
				return false;
			}
			return true;
	}

	@Override
	public RouteBean findByID(String ID) {
		try{
			Session session=sessionFactory.openSession();
			org.hibernate.Transaction tx=session.beginTransaction();
			routebean = (RouteBean)session.get(RouteBean.class, ID);
			
			}catch(HibernateException he){
				return null;
			}
		
		// TODO Auto-generated method stub
		return routebean;
	}

	@Override
	public ArrayList<RouteBean> viewByAllRoute() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("from RouteBean");
		
		tx.commit();
		//session.close();
		
		@SuppressWarnings("unchecked")
		ArrayList<RouteBean> list=(ArrayList<RouteBean>) query.list();
		
		if(list.isEmpty())
		{
			return null;
		}
		
		return list;
	}

	@Override
	public String findRoute(String source, String destination) {
		try{
			String hql = "Select R.routeID FROM RouteBean R WHERE R.source = :source AND R.destination = :destination";
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("source",source);
			query.setParameter("destination", destination);
			List<String> routeids =(ArrayList<String>) query.list();
			return routeids.get(0);
		}
			catch(HibernateException he){
				return "Invalid";
			}
		catch(Exception e){
			return "FAIL";
		}
		
	}

}
