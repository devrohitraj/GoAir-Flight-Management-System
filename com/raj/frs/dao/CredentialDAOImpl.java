package com.raj.frs.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
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

@Repository
@Transactional
public class CredentialDAOImpl implements CredentialsDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	CredentialsBean credentialsbean;
	
	@Override
	public String findSequence() {
		
		
		String profile_seq = "FRS_SEQ_USER_ID";
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
				
		SQLQuery query=session.createSQLQuery("select "+profile_seq+".nextval from dual");
		
		List list=query.list();
		BigDecimal big=(BigDecimal)list.get(0);
		int seq=big.intValue();
		
		
		return String.valueOf(seq);
		
	}

	@Override
	public String createCredentials(CredentialsBean credentials) {
		
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(credentials);
		tx.commit();
		}catch(HibernateException he){
			return "FAIL";
		}catch(Exception e){
			return "ERROR";
		}
		return "SUCCESS";
		
		
	}

	@Override
	public int deleteCredentials(ArrayList<String> idList) {


		
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
	public boolean updateCredentials(CredentialsBean credentials) {
		try{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.update(credentials);
			
			tx.commit();
			
			}catch(HibernateException e){
				return false;
			}
			return true;
			
			
		}
	

	@Override
	public boolean updateCredentials(String userID, int status) {
		
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		credentialsbean = (CredentialsBean)session.get(CredentialsBean.class, userID);
		credentialsbean.setLoginStatus(status);
		tx.commit();
		session.update(credentialsbean);
		}catch(HibernateException he){
			return false;
		}
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public CredentialsBean findByID(String ID) {
		
		try{
			Session session=sessionFactory.openSession();
			org.hibernate.Transaction tx=session.beginTransaction();
			credentialsbean = (CredentialsBean)session.get(CredentialsBean.class, ID);
			
			}catch(HibernateException he){
				return null;
			}
		
		// TODO Auto-generated method stub
		return credentialsbean;
	}

	@Override
	public ArrayList<CredentialsBean> findAll() {


		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("from CredentialsBean");
		
		tx.commit();
		//session.close();
		
		@SuppressWarnings("unchecked")
		ArrayList<CredentialsBean> list=(ArrayList<CredentialsBean>) query.list();
		
		if(list.isEmpty())
		{
			return null;
		}
		
		return list;
	}
	
	

}
