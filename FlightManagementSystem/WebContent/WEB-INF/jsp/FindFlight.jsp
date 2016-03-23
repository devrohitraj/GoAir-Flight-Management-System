<%@page import="com.wipro.frs.bean.FlightBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="tcal.css" />
<script type="text/javascript" src="tcal.js">
</script>
<style>
.error {
	color: #ff000;
	font-style: italic;
}
</style>
</head>
<body bgcolor="lightgreen">
<center>

${MSG}
	<%
		FlightBean flight= (FlightBean) request.getAttribute("flight");
		if (flight!= null) {
	%>
	<table align="center" height="450" width="600">
		<tr>
			<td>Ship ID</td>
			<td><%=flight.getFlightID()%></td>
		</tr>
		<tr>
			<td>ShipName</td>
			<td><%=flight.getFlightName()%></td>
		</tr>
		<tr>
			<td>SeatingCapacity</td>
			<td><%=flight.getSeatingCapacity()%></td>
		</tr>
		
		<tr>
			<td>ReservationCapacity</td>
			<td><%=flight.getReservationCapacity()%></td>
		</tr>
		
		
		
	</table>
	<%
		}
	%>

</center>
</body>
</html>