<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<br>
<br>
<h3 align="center">
		<font color="#5B5D5F">Enter following details to search</font>
	</h3>
	<br>
<br>
<center>

${MSG}
<form:form action="FindFlight.html" commandName="flight" >
	
		<table bgcolor="#AABBCC" border=1% bordercolor="#393F45" align="center">
		
			<tr>	<td>Flight ID</td>
				<td><form:select  name="FlightID"
						path="flightID" required="required">
						<form:option value="NONE" label="----Select----"></form:option>
						<form:options items="${flightID}" />
					</form:select>
					</td>
			</tr>
	<tr align="center"><td></td>
			
			<td ><input type="submit" value="view" name="action"></td>
		</tr>
</table>
</form:form>

</center>

</body>
</html>