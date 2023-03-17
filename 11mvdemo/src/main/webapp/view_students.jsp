<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<table border="1">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
</tr>
<c:forEach var="user" items="${user_list}">
<tr>
<td>${user.firstname}</td>
<td>${user.lastname }</td>
<td>${user.email }</td>
</tr>
</c:forEach>

</table>

</body>
</html>