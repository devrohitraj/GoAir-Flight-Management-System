
package com.raj.frs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FRS_TBL_Route")
public class RouteBean {
@Id

	private String routeID;
@NotEmpty(message="Source cant be empty")
	private String source;
@NotEmpty(message="Destination cant be empty")
	private String destination;
@NotNull(message="Distance cant be empty")
	private int distance;

@NotNull
	private double fare;

	
	public String getRouteID() {
		return routeID;
	}

	
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	
	public String getSource() {
		return source;
	}

	
	public void setSource(String source) {
		this.source = source;
	}

	
	public String getDestination() {
		return destination;
	}

	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public int getDistance() {
		return distance;
	}

	
	public void setDistance(int distance) {
		this.distance = distance;
	}

	
	public double getFare() {
		return fare;
	}

	
	public void setFare(double fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "RouteBean [routeID=" + routeID + ", source=" + source
				+ ", destination=" + destination + ", distance=" + distance
				+ ", fare=" + fare + "]";
	}

}
