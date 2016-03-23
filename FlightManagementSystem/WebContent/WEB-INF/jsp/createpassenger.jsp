<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create passenger</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</head>
<body>

<br />
	<br />
	<div style="padding-left: 250px; padding-right: 250px;">
		<spring:form action="createpassengerindb.html" modelAttribute="createpassenger" >
			<table class="table table-bordered table-hover">
				<tr style="background-color: black;color: white;">
					<th colspan="2" class="h3"><center>create passenger</center></th>
				</tr>
				<!-- <tr>
					<td>Reservation ID</td>
					<td><input class="form-control" path="uid"
							required="required" /></td>
				</tr> -->
				<tr>
					<td>Name</td>
					<td><spring:input class="form-control" path="name"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Gender</td>
					<td><spring:input class="form-control" path="gender"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Age</td>
					<td><spring:input class="form-control" path="age"
							required="required" /></td>
				</tr>
				
				<tr>
					<td>Seat no.</td>
					<td><spring:input class="form-control" path="seatNo"
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