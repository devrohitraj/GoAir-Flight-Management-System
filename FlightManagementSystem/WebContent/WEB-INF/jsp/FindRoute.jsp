<%@page import="com.wipro.frs.bean.RouteBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="tcal.css" />
<script type="text/javascript" src="tcal.js">
</script>
<style>
.error {
	color: #ff000;
	font-style: italic;
}
</style>
</head>
<body bgcolor="lightgreen">
<center>

${MSG}
	<%
		RouteBean route = (RouteBean) request.getAttribute("route");
		if (route != null) {
	%>
	<table align="center" height="450" width="600">
		<tr>
			<td>Route ID</td>
			<td><%=route.getRouteID()%></td>
		</tr>
		<tr>
			<td>Source</td>
			<td><%=route.getSource()%></td>
		</tr>
		<tr>
			<td>Destination</td>
			<td><%=route.getDestination()%></td>
		</tr>
		
		<tr>
			<td>Travel Duration</td>
			<td><%=route.getDistance()%></td>
		</tr>
		
		
	</table>
	<%
		}
	%>
</table>

</center>
</body>
</html>