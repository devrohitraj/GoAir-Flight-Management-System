
package com.raj.frs.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FRS_TBL_Schedule")
public class ScheduleBean {
@Override
	public String toString() {
		return "ScheduleBean [scheduleID=" + scheduleID + ", flightID="
				+ flightID + ", routeID=" + routeID + ", travelDuration="
				+ travelDuration + ", availableDays=" + availableDays
				+ ", departureTime=" + departureTime + "]";
	}


@Id
	private String scheduleID;
@NotEmpty(message="FlightID cant be empty")
@ForeignKey(name="FRS_TBL_User_Flight")
	private String flightID;
@NotEmpty(message="route ID cant be empty")
	@ForeignKey(name="FRS_TBL_User_Route")
	private String routeID;
	@NotNull(message="travel duration cant be empty")
	private int travelDuration;

/*	private List<String> availableDays;
*/
	@NotEmpty(message="Available Days cant be empty")
	private String availableDays;
	@NotEmpty(message="departure Time cant be empty")
	private String departureTime;
	
	
	public String getScheduleID() {
		return scheduleID;
	}

	
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	
	public String getFlightID() {
		return flightID;
	}

	
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	
	public String getRouteID() {
		return routeID;
	}

	
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	
	public int getTravelDuration() {
		return travelDuration;
	}

	
	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}

	
	
	
	/*
	public List<String> getAvailableDays() {
		return availableDays;
	}


	
	public void setAvailableDays(List<String> availableDays) {
		this.availableDays = availableDays;
	}*/


	
	public String getAvailableDays() {
		return availableDays;
	}


	
	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}


	public String getDepartureTime() {
		return departureTime;
	}

	
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
}
