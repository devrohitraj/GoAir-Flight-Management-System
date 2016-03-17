
package com.raj.frs.bean;

import javax.persistence.Id;


public class TicketBean {
	
	
	private String reservationID;
	private String flightID;
	private String name;
	private int age;
	private int seatNo;
	private String source;
	private String destination;
	private double totalFare;
	
	@Override
	public String toString() {
		return "TicketBean [reservationID=" + reservationID + ", flightID="
				+ flightID + ", name=" + name + ", age=" + age + ", seatNo="
				+ seatNo + ", source=" + source + ", destination="
				+ destination + ", totalFare=" + totalFare + "]";
	}
	
	public String getReservationID() {
		return reservationID;
	}
	
	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}
	
	public String getFlightID() {
		return flightID;
	}
	
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getSeatNo() {
		return seatNo;
	}
	
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
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
	
	
	public double getTotalFare() {
		return totalFare;
	}
	
	
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	
	
	
	
	
	
}
