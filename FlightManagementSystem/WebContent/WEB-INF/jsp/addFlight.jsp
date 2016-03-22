		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.flight" /></title>

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
<jsp:include page="Design.jsp"/>
	${MSG}
	<form:form action="addFlight.form" commandName="flight">
		<div class="container">		
		<table class="table table-hover">
		<%-- 
			<spring:message code="login.RouteID"/> 		
			<form:input path="routeID" /> --%>
			<tr>
			<td><spring:message code="login.flightName" /></td>
			<td><form:input path="flightName"/></td>
			<td><form:errors path="flightName" cssClass="error" />
			</tr>
			<tr>
			<td><spring:message code="login.seatingCapacities" /></td>
			<td><form:input path="seatingCapacity"  /></td>
			<td><form:errors path="seatingCapacity" cssClass="error" />
			</tr>
			<tr>
			<td><spring:message code="login.reservationCapacities" /></td>
			<td><form:input path="reservationCapacity"  /></td>
			<td><form:errors path="reservationCapacity" cssClass="error" />
			</tr>
			<tr>
			<td><form:button value="ADD FLIGHT" class="btn btn-primary">
				<spring:message code="login.add" />
			</form:button></td>
			</tr>
			</table>
		</div>
	</form:form>
	
</body>
</html>