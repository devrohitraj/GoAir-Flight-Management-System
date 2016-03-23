<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form id="yourForm" action="deleteFlight.html" method="get">
<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                	<td>SELECT</td>
                    <td>flightID</td>
                    <td>flightName</td>
                    <td>seatingCapacity</td>
                    <td>reservationCapacity</td>
                  
                    
                </tr>
                <c:forEach items="${arr}" var="arr">

                    <tr>
                    <td><input type="checkbox" id="c1" name="c" value="${arr.flightID}"/></td>
                        <td><c:out value="${arr.flightName}" /></td>
                        <td><c:out value="${arr.seatingCapacity}" /></td>

                        <td><c:out value="${arr. reservationCapacity}" /></td>
                        
                        
                    </tr>

                </c:forEach>
            </table>
            <input type="submit" value="delete" />
            </form:form>
</body>
</html>