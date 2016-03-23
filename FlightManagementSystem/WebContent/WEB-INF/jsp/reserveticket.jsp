<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reserve ticket</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</head>
<body>

<br />
	<br />
	<div style="padding-left: 250px; padding-right: 250px;">
		<spring:form action="reserveticketindb.html" modelAttribute="reservationBean" >
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>reserve ticket</center></th>
				</tr>
				<!-- <tr>
					<td>Reservation ID</td>
					<td><input class="form-control" path="uid"
							required="required" /></td>
				</tr> -->
				<tr>
					<td>Reservation Type</td>
					<td><spring:input class="form-control" path="reservationType"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Booking Date</td>
					<td><spring:input class="form-control" path="bookingDate"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Journey Date</td>
					<td><spring:input class="form-control" path="journeyDate"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>No of Seats</td>
					<td><spring:input class="form-control" path="noOfSeats"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Total Fare</td>
					<td><spring:input class="form-control" path="totalFare"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Booking Status</td>
					<td><spring:input class="form-control" path="bookingStatus"
							required="required" /></td>
				</tr>
				
				
				
				<tr style="background-color: black;
	color: white;">
					<td colspan="2" align="center"><input type="submit"
						value="Register" class="btn btn-primary">&nbsp;&nbsp;&nbsp; <input
						class="btn btn-primary" type="reset"></td>
				</tr>
			</table>
			<!-- <span id ="res" value=${res}></span> -->
		</spring:form>
	</div>
</body>
</html>