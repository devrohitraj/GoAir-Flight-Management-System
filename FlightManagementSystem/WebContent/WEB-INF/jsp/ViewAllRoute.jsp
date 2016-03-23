<%@page import="java.util.Iterator"%>
<%@page import="com.wipro.frs.bean.RouteBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/TableStyle.css">
</head>
<body>


<table align="center"  border="2">
				<tr align="center">
					<th>Route ID</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Distance</th>
					<th>Fare</th>
					
				</tr>
				<c:forEach var="route" items="${routeList}">
					<tr align="center">
						<td>${route.routeID} </td>
						<td>${route.source} </td>
						<td>${route.destination} </td>
						<td>${route.Distance} </td>
						<td>${route.fare} </td>
					</tr>
				</c:forEach>
				
				
			</table>
			
	
	</body>
</html>