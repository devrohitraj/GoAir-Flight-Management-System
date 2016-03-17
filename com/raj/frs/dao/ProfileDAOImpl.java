package com.raj.frs.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raj.frs.bean.ProfileBean;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO{
	
	@Autowired
	SessionFactory sessionFactory;

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
	public String createUser(ProfileBean profilebean) {
		try{
			//String sequence = findSequence();
			//sequence = profilebean.getFirstName().substring(0, 2).toUpperCase()+sequence;
			//profilebean.setUserID(sequence);
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(profilebean);
			tx.commit();
			}catch(HibernateException he){
				return "FAIL";
			}catch(Exception e){
				return "ERROR";
			}
			return "SUCCESS";
	}

}
