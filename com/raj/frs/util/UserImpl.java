package com.raj.frs.util;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.ProfileBean;

import com.raj.frs.dao.CredentialsDAO;

import com.raj.frs.dao.ProfileDAO;

public class UserImpl implements User {
@Autowired 
private CredentialsDAO  credentialsBeanDAO;
@Autowired 
private CredentialsBean credentialsBean ;
@Autowired 
private ProfileDAO profileBeanDAO;

@Override
  public String login(CredentialsBean credentialsBean) {
  String result = "FAIL";
   if (credentialsBean != null && credentialsBean.getUserID()!=null) {
  CredentialsBean cb = credentialsBeanDAO.findByID(credentialsBean.getUserID());
          if (cb != null && cb.getPassword().equals(credentialsBean.getPassword())) {
	      cb.setLoginStatus(1);
          boolean f = credentialsBeanDAO.updateCredentials(cb);
               if(f){
            	   
                   result = cb.getUserType();
		       }
	           else
	           {
	               result="INVALID";
		       }
          }
   }
		return result;
}
		
	@Override
	public String register(ProfileBean profileBean) {
		String r = null;
		if(profileBean!=null)
		{
			String seq=credentialsBeanDAO.findSequence();
			String s=credentialsBean.getUserType()+seq;
			credentialsBean.setLoginStatus(0);
			credentialsBean.setUserType("C");
			credentialsBean.setNewPassword(profileBean.getPassword());
			credentialsBean.setConfirmPassword(profileBean.getConfirmPassword());
			if(credentialsBeanDAO.createCredentials(credentialsBean).equalsIgnoreCase("SUCCESS")){
				profileBean.setUserID(s);
				return profileBeanDAO.createUser(profileBean);
			}
			else{
				return "INVALID";
			}
		}
			
		return "FAIL";
	
		}
@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
	String id=credentialsBean.getUserID();
	String s ="FAIL";
	if(credentialsBean!=null&&id!=null)
	{try
	{
		CredentialsBean cb=credentialsBeanDAO.findByID(id);
		cb.setPassword(newPassword);
		credentialsBeanDAO.updateCredentials(cb);
		s="SUCCESS";
	}
	catch(HibernateException e)
	{
		s="INVALID";
	}
	
	catch(Exception e)
	{
		
		s="FAIL";
	}
}
	return s;
}
	@Override
	public boolean logout(String userId) {
		CredentialsBean s=credentialsBeanDAO.findByID(userId);
		if(s!=null){
			boolean b=credentialsBeanDAO.updateCredentials(userId, 0);
		return b;
		}
		return false;
	}
	

}
