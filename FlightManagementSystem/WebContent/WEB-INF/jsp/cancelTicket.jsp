<%@page import="com.wipro.frs.bean.ReservationBean"%>

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
<jsp:include page="CustomerDesign.jsp"></jsp:include>
	${MSG} 
	<form:form action="cancelTicket.form" commandName="reserve">			
			<table align="center" height="100" width="600">
				<tr>
					<td>Enter Reservation ID</td><td><input type="text" name="reservationID">
					</td>
					<td> <input type="submit" value="cancel ticket"> </td>
				</tr>
</table>
</form:form>
</body>
</html>