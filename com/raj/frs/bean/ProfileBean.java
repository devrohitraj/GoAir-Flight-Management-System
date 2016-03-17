
package com.raj.frs.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "FRS_TBL_User_Profile")
public class ProfileBean {
	@Id
	@ForeignKey(name="FRS_TBL_User_Credentials")
	private String userID;
	@Size(min = 2, max = 10)
	@NotEmpty(message="First Name cant be empty")
	private String firstName;
	@Size(min = 2, max = 10)
	@NotEmpty(message="Last Name cant be empty")
	private String lastName;
	@Past
	private Date dateOfBirth;
	@NotEmpty(message="Field cant be empty")
	private String gender;
	@NotEmpty(message="Street cant be empty")
	private String street;
	@NotEmpty(message="Location cant be empty")
	private String location;
	@NotEmpty(message="City cant be empty")
	private String city;
	@NotEmpty(message="State cant be empty")
	private String state;
	@NotEmpty(message="PinCode cant be empty")
	@Size(min = 6,max=6)
	private String pincode;
	@NotEmpty(message="MobileNO cant be empty")
	@Size(min = 10, max = 10)
	private String mobileNo;
	@NotEmpty(message="Email ID cant be empty")
	@Email(message="Email is not valid")
	private String emailID;
	@NotEmpty(message="Password cant be empty")

	private String password;
	
	//@NotEmpty(message="Confirm Password cant be empty")
	@Transient
	private String confirmPassword;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
