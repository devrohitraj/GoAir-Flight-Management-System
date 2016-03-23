 <%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${flightID!=null}">
			
			<table align="center" height="400">
				<tr>
					<th>flightID&nbsp;&nbsp;&nbsp;</th>
					<th>flightName &nbsp;&nbsp;&nbsp;</th>
					<th>seatingCapacity &nbsp;&nbsp;&nbsp;</th>
					<th>reservationCapacity &nbsp;&nbsp;&nbsp;</th>
					
				</tr>
				
				<c:forEach var="flight" items="${FlightList}">
					<tr>
						<td>${flight.flightID} &nbsp;&nbsp;&nbsp;</td>
						<td>${flight.flightName} &nbsp;&nbsp;&nbsp;</td>
						<td>${flight.seatingCapacity} &nbsp;&nbsp;&nbsp;</td>
						<td>${flight.reservationCapacity} &nbsp;&nbsp;&nbsp;</td>
						
					</tr>
				</c:forEach>
				
				<tr>
					<td>${Message}</td>
				</tr>
				<tr></tr>
				<tr></tr>
				
			</table>
			
		</c:when>
		<c:otherwise>
			<c:out value="Your session expired, please login"></c:out>
			
		</c:otherwise>
	</c:choose>
</body>
</html>