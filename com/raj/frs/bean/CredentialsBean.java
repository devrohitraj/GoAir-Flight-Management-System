package com.raj.frs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "FRS_TBL_User_Credentials")

public class CredentialsBean {
	public CredentialsBean() {
		// TODO Auto-generated constructor stub
		System.out.println("I am in Credentials Bean");
	}

	@Id
	@Column(name="userID")
	
	private String userID;
	@Column(name="password")
	
	private String password;
	@Column(name="userType")
	
	private String userType;
	@Column(name="loginStatus")
	
	private int loginStatus;
	
	@Transient
	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*]{6,16}")
	private String newPassword="Password";

	@Transient
	private String confirmPassword="Password";
	
	
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public int getLoginStatus() {
		return loginStatus;
	}
	
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	
}
