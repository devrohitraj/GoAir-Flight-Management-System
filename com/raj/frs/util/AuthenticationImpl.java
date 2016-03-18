package com.raj.frs.util;


import org.springframework.beans.factory.annotation.Autowired;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.dao.CredentialsDAO;

public class AuthenticationImpl implements Authentication {
	@Autowired 
	private CredentialsDAO  credentialsDAO;
	public boolean authenticate(CredentialsBean credentialsBean)
	{
	 String seq= credentialsDAO.findSequence();
	 String id=credentialsBean.getUserType()+seq;
	 credentialsBean.setUserID(id);
		if(credentialsBean!=null||credentialsBean.getUserID()!=null||credentialsBean.getPassword()!=null)
		{
			String id1=credentialsBean.getUserID();
			CredentialsBean cb=credentialsDAO.findByID(id1);
			if(cb!=null)
			{
			return true;
			}
		}
		return false;
		
	}
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus)
	{
		return credentialsDAO.updateCredentials(credentialsBean.getUserID(), loginStatus);
		
	}
	@Override
	public String authorize(String userId) {
	CredentialsBean cb=credentialsDAO.findByID(userId);
	String s=cb.getUserType();
	
	if(s.equalsIgnoreCase("A"))
	{
		return "SUCCESS";
	}
	else
	
	{
		return "FAIL";
	}
	}
}
