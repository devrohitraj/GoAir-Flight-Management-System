<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
 <style>
             body {
                background-image: url(airplane.jpg);            
                background-size: 150%;
                background-origin: content;
                background-repeat: no-repeat;
             }
 
          </style>
</head>
<body>
<img src="plane.gif">

		<div>
		<table align="right"  height="20" width="300">
			<tr>
			
				<td><jsp:include page="Text.jsp"></jsp:include></td>
			</tr>
			<tr>
			
				<td></td>
				<td></td>
				<td style="color:green;">Welcome to::${userID}
				<a href="logout.form">Logout</a>
				 <a	href="changePassword.form">Change Password</a></td>
			</tr>
		</table>
	</div>
	<div>
		<table align="left"  height="600" width="500">
			<tr>
				<td><jsp:include page="AdminMenu.jsp"></jsp:include></td>
			</tr>
		</table>
	</div>
	<div>
		<table align="center" bgcolor="black" height="30" width="1000">
			<tr>
				<td><jsp:include page="Footer.jsp"></jsp:include></td>
			</tr>
		</table>
	</div>
</body>
</html>
