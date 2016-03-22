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
	<form:form action="addRoute.form" commandName="route">
		<div class="container">		
		<%-- 
			<spring:message code="login.RouteID"/> 		
			<form:input path="routeID" /> --%>
			<table class="table table-hover">
			<tr>
			<td><spring:message code="login.Source" />
			
			<td><select name="source" class="select-field">
			<option label="------SELECT----"  />
                <option value="Kolkata">Kolkata</option>
                <option value="Chennai">Chennai</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Delhi">Delhi</option>
                <option value="Hyderabad">Hyderabad</option>
                <option value="Bangalore">Bangalore</option>
                <option value="Cochin">Cochin</option>
                <option value="Bhopal">Bhopal</option>
                <option value="Allahabad">Allahabad</option></td>
                <td><form:errors path="source" cssClass="error" />
            </select></td>
            
			</tr>
			<tr>
			<td><spring:message code="login.Destination" /></td>
			
			<td><select name="destination" class="select-field">
				<option label="----SELECT----" ></option>
                <option value="Kolkata">Kolkata</option>
                <option value="Chennai">Chennai</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Delhi">Delhi</option>
                <option value="Hyderabad">Hyderabad</option>
                <option value="Bangalore">Bangalore</option>
                <option value="Cochin">Cochin</option>
                <option value="Bhopal">Bhopal</option>
                <option value="Allahabad">Allahabad</option></td>
                <td><form:errors path="destination" cssClass="error" />
            </select></td>
			</tr>
			<tr>
			
			<td><spring:message code="login.Distance" /></td>
			<td><form:input path="distance"  /></td>
			<td><form:errors path="distance" cssClass="error" /></td>
			</tr>
			<tr>
			<td><spring:message code="login.Fare" /></td>
			<td><form:input path="fare" /></td>
			<td><form:errors path="fare" cssClass="error" /></td>
	
			</tr>
			<tr>
			<td><form:button value="ADD ROUTE" class="btn btn-primary">
				<spring:message code="login.add" />
				
			</form:button></td>
			</tr>
			</table>
		</div>
	</form:form>
	
</body>
</html>