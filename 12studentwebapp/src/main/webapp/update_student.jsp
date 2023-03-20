<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="updatestudent" method="post">

<input type="hidden" name="studentId" value="${STUDENT.id}"/>

<table>
<tr>
<td>FIRSTNAME:</td>
<td> <input name="firstname" value="${STUDENT.firstname}"/></td>
</tr>
<tr>
<td>LASTNAME:</td>
<td><input name="lastname" value="${STUDENT.lastname}"/></td>
</tr>
<tr>
<td>EMAILID:</td>
<td><input name="emailid" value="${STUDENT.email}"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="save"/></td>
</tr>
</table>
</form>
<a href="index.html">BACK to List</a>

</body>
</html>