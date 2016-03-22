<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="change.title" /></title>

<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="js/jquery-2.2.0.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
<jsp:include page="Design.jsp"></jsp:include>
<br><br><br><br><br><br>
	<center>
		<form:form name="changePassword"
			action='<%=response.encodeRedirectURL("changePassword.form")%>'
			commandName="credentials">
			<div class="container">
			

				Old Password :
				<form:password path="password"  class="form-control"/>
				<form:errors path="password" cssClass="error" />
				<br>
				<br>
				


				New Password :
				<form:password path="newPassword" class="form-control" />
				<form:errors path="newPassword" cssClass="error" />
				<br>
				<br>
				<br>


				Confirm Password :
				<form:password path="confirmPassword" class="form-control" />
				<form:errors cssClass="error" />
				<br>
				<br>
				<br>


				<form:button value="Change">Change</form:button>

			</div>
		</form:form>
	</center>
	
</body>
</html>