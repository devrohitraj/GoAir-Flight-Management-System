<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form action="submitnewuser.html" modelAttribute="myuser"
		method="get">
		<table>
			<tr>
				<td>firstName</td>
				<td><spring:input path="firstName" /></td>
			</tr>
			<tr>
				<td>lastName</td>
				<td><spring:input path="lastName" /></td>
			</tr>
			<tr>
				<td>dateOfBirth</td>
				<td><spring:input path="dateOfBirth" /></td>
			</tr>
			
			<tr>
				<td>street</td>
				<td><spring:input path="street" /></td>
			</tr>
			<tr>
				<td>location</td>
				<td><spring:input path="location" /></td>
			</tr>
			<tr>
				<td>city</td>
				<td><spring:input path="city" /></td>
			</tr>
			<tr>
				<td>state</td>
				<td><spring:input path="state" /></td>
			</tr>
			<tr>
				<td>pincode</td>
				<td><spring:input path="pincode" /></td>
			</tr>
			<tr>
				<td>mobileNo</td>
				<td><spring:input path="mobileNo" /></td>
			</tr>
			<tr>
				<td>emailID</td>
				<td><spring:input path="emailID" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><spring:input path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
			<tr>
				<td></td>
				<td>
		</table>
	</spring:form>
</body>
</html>