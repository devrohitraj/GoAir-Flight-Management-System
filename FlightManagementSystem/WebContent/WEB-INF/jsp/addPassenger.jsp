<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.passenger" /></title>

<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="js/jquery-2.2.0.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<center>
	${MSG}
	<form:form action="addPassenger.form" commandName="passenger">
		<div class="container">

			<spring:message code="passengerOperation.reservationID" />
			<form:input path="reservationID" class="form-control" />
            
            <spring:message code="login.name" />
			<form:input path="name" class="form-control" />
			
            
            <spring:message code="login.gender" />
			<form:radiobutton path="gender" value="male"  class="form-control" />
		    <form:radiobutton path="gender" value="female" class="form-control" />
           
            
            <spring:message code="login.age" />
			<form:input path="age" class="form-control" />
			
			<spring:message code="passengerOperation.seatNo" />
			<form:password path="seatNo" class="form-control" />
            
			<form:button value="ADD PASSENGER" class="btn btn-primary"/>
				<spring:message code="login.add" />
			
			
	
		</div>
	
	</form:form>
	
</center> 

</body>
</html>