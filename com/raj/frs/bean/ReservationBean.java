
package com.raj.frs.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FRS_TBL_Reservation")
public class ReservationBean {

	@Id
	@Column(name="reservationID")
	private String reservationID;

	//@NotNull
	@ForeignKey(name="FRS_TBL_USER_PROFILE")
	private String userID;

	@ForeignKey(name="FRS_TBL_SCHEDULE")
	//@NotNull
	private String scheduleID;

	//@NotEmpty(message = "Field cant be empty")
	private String reservationType;

	//@NotEmpty(message = "Field cant be empty")
	private Date bookingDate;

	//@NotEmpty(message = "Field cant be empty")
	private Date journeyDate;

	//@NotEmpty(message = "Field cant be empty")
	private int noOfSeats;
	@Transient
	//@Formula(" routebean.getDistance() * routebean.getFare()")
	private double totalFare;

	//@NotEmpty(message = "Field cant be empty")
	private int bookingStatus;
	@Transient
	private RouteBean routebean;

	
	public RouteBean getRoutebean() {
		return routebean;
	}

	
	public void setRoutebean(RouteBean routebean) {
		this.routebean = routebean;
	}

	
	public String getReservationID() {
		return reservationID;
	}

	
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	
	public String getUserID() {
		return userID;
	}

	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getScheduleID() {
		return scheduleID;
	}

	
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	
	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	
	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	
	public Date getJourneyDate() {
		return journeyDate;
	}

	
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	
	public int getNoOfSeats() {
		return noOfSeats;
	}

	
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	
	public double getTotalFare() {
		return totalFare;
	}

	
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	
	public int getBookingStatus() {
		return bookingStatus;
	}

	
	public void setBookingStatus(int bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "ReservationBean [reservationID=" + reservationID + ", userID="
				+ userID + ", scheduleID=" + scheduleID + ", reservationType="
				+ reservationType + ", bookingDate=" + bookingDate
				+ ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare + ", bookingStatus="
				+ bookingStatus + ", routebean=" + routebean + "]";
	}
	
	
	

}
