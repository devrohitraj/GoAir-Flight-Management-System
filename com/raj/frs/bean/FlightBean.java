
package com.raj.frs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FRS_TBL_Flight")
public class FlightBean {
@Id
	private String flightID;
@NotEmpty(message="Flight Name cant be empty")
	private String flightName;
@NotNull(message="Seating Capacity cant be empty")
	private int seatingCapacity;
@NotNull(message="Reservation Capacity cant be empty")
	private int reservationCapacity;

	
	public String getFlightID() {
		return flightID;
	}

	
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	
	public String getFlightName() {
		return flightName;
	}

	
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	
	public int getReservationCapacity() {
		return reservationCapacity;
	}

	
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	
}
