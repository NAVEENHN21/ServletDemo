<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User list</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Delete</th>
</tr>

<c:forEach var="student" items="${student_list}">
<tr>
<td><a href="loadstudent?studentID=${student.id}" >1</a></td>
<td>${student.firstname}</td>
<td>${student.lastname }</td>
<td>${student.email }</td>
<td><a href="deletestudent?studentID=${student.id}" >Delete</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>