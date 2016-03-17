
package com.raj.frs.bean;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FRS_TBL_CreditCard")
public class CreditCardBean {

	@Id
	//@NotEmpty(message="cardnumber Name cant be empty")
	private String creditCardNumber;
	@Column
	//@NotEmpty(message="pin Number cant be empty")
	private String pin;
	
	@Column(name = "userid")
	@ForeignKey(name = "frs_tbl_user_credentials")
	private String userID;
	@Column
	private double creditBalance;
	@Column
	
	private Date validFrom;
	@Column
	private Date validTo;
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public double getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "CreditCardBean [creditCardNumber=" + creditCardNumber + ", pin=" + pin + ", userID=" + userID
				+ ", creditBalance=" + creditBalance + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}
	
	

	

}
