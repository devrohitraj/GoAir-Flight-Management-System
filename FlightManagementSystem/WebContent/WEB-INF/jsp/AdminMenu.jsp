<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style >
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
</head>
<body>

 <div class="dropdown">
  <button class="dropbtn">Flight</button>
  <div class="dropdown-content">
    <a href="addFlight.form">Add</a> <a href="flightID.form">Modify</a>
			<a href="flightID.form">View</a> <a href="viewByAllFlight.form">View
				All</a> <a href="flightID.form">Delete</a>
  </div>
  </div>
  <div class="dropdown">
  <button class="dropbtn">Route</button>
  <div class="dropdown-content">
  <a href="addRoute.form">Add</a> <a href="routeID.form">Modify</a>
			<a href="routeID.form">View</a> <a href="viewAllRoute.form">View
				All</a> <a href="routeID.form">Delete</a>
  </div>
</div>
<div class="dropdown">
  <button class="dropbtn">Schedule</button>
  <div class="dropdown-content">
  <a href="addSchedule.form">Add</a> <a href="scheduleID.form">Modify</a>
			<a href="scheduleID.form">View</a> <a href="viewAllSchedule.form">View
				All</a> <a href="scheduleID.form">Delete</a>
  </div>
  </div>
</body>
</html>