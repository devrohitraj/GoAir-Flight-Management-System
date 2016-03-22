<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.schedule" /></title>

<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="js/jquery-2.2.0.js"></script>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="Design.jsp"></jsp:include>
	${MSG}
	<form:form action="addSchedule.form" commandName="schedule">
		<div class="container">
			<%-- 
			<spring:message code="login.RouteID"/> 		
			<form:input path="routeID" /> --%>
			
			<table class="table table-hover">
			<%-- <tr>
			
			<td><spring:message code="login.flightID" /></td>
			<td><form:input path="flightID" /></td>
			</tr> --%>
			<tr>
				<td>Flight ID</td>
				<td><form:select  name="flightID"
				
						path="flightID" required="required">
						<form:option value="NONE" label="----Select----"></form:option>
						<form:options items="${flightID}" />
						<td><form:errors path="flightID" cssClass="error" />
					</form:select></td>
			</tr>
			<%-- <%-- <tr>
			<td><spring:message code="login.routeID" /></td>
			<td><form:input path="routeID" /></td>
			</tr> --%> 
			
			<td>Route ID</td>
				<td><form:select  name="routeID"
						path="routeID" required="required">
						<form:option value="NONE" label="----Select----"></form:option>
						<form:options items="${routeID}" />
						<td><form:errors path="routeID" cssClass="error" />
					</form:select></td>
			
			<tr>
			<td><spring:message code="login.duration" /></td>
			<td><form:input path="travelDuration" /></td>
			<td><form:errors path="travelDuration" cssClass="error" />
			</tr>
			<tr>
			<td><spring:message code="login.availableDays" /></td>
			<%-- <form:input path="availableDays" /> --%>
		
				<td><input type="checkbox" name="availableDays" value="Mon" />Mon
				<input type="checkbox" name="availableDays" value="Tue" />Tue
				<input type="checkbox" name="availableDays" value="Wed" />Wed
				<input type="checkbox" name="availableDays" value="Thu" />Thu
				<input type="checkbox" name="availableDays" value="Fri" />Fri
				<input type="checkbox" name="availableDays" value="Sat" />Sat
				<input type="checkbox" name="availableDays" value="Sun" />Sun</td>
				<td><form:errors path="availableDays" cssClass="error" />
				
			</tr>
			<tr>
			<td><spring:message code="login.departureTime" /></td>
			<td><form:input path="departureTime" /></td>
			<td><form:errors path="departureTime" cssClass="error" />
			<tr>

			<td><form:button value="ADD Schedule" class="btn btn-primary">
				<spring:message code="login.add" />
			</form:button></td>
			</tr>
			</table>
		</div>
	</form:form>

</body>
</html>