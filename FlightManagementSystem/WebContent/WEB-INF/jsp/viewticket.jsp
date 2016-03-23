<%@page import="java.util.Iterator"%>
<%@page import="com.wipro.frs.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/TableStyle.css">
</head>
<body>


<table align="center"  border="2">
				<tr align="center">
					<th>Reservation ID</th>
					<th>Reservation Type</th>
					<th>Booking Date</th>
					<th>Journey date</th>
					<th>No of Seats</th>
					<th>Total Fare</th>
					<th>Booking Status</th>
					
				</tr>
				<c:forEach var="reservationBean" items="${reservation}">
					<tr align="center">
						<td>${reservationBean.reservationID} </td>
						<td>${reservationBean.reservationType} </td>
						<td>${reservationBean.bookingDate} </td>
						<td>${reservationBean.journeyDate} </td>
						<td>${reservationBean.noOfSeats} </td>
						<td>${reservationBean.totalFare} </td>
						<td>${reservationBean.bookingStatus} </td>
					</tr>
				</c:forEach>
				
				
			</table>
			<input type="button" value="Print your ticket" onClick="window.print()">
	
	</body>
</html>