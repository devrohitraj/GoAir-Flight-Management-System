package com.raj.frs.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.raj.frs.bean.CredentialsBean;



public interface CredentialsDAO {

	String findSequence();
	
	String createCredentials(CredentialsBean credentials);

	int deleteCredentials(ArrayList<String> idList);

	
	boolean updateCredentials(CredentialsBean credentials);
	
	
	boolean updateCredentials(String userID, int status);
	

	CredentialsBean findByID(String ID);

	
	ArrayList<CredentialsBean> findAll();

}
