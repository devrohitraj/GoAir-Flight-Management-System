<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${MSG}


<br>
<br>


	<h3 align="center">
		<font color="#5B5D5F">Enter reservation ID to delete</font>
	</h3>

	<br>
	<br>
<center>
	
	<form:form action="submitcancelticket.html" commandName="reservation" modelAttribute="reservation">
	
			<table bgcolor="#AABBCC" border=1% bordercolor="#393F45" align="center">

		<tr>	<td>reservationID</td>
				<td><form:select  name="reservationID"
						path="reservationID" required="required">
						<form:option value="NONE" label="----Select----"></form:option>
						<form:options items="${scheduleID}" />
					</form:select></td>
			</tr>
			<tr align="center">
			<td>	<td><input type="submit" value="Delete">
			</tr>
		</table>
		
	
	</form:form>
	</center>
	<br>
	<br>
	<center>
	${MSG}
	</center>
</body>
</html>