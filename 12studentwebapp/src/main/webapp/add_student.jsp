<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UpdateStudentServlet" method="post">
<table>
<tr>
<td>FIRSTNAME:</td>
<td> <input name="firstname"/></td>
</tr>
<tr>
<td>LASTNAME:</td>
<td><input name="lastname"/></td>
</tr>
<tr>
<td>EMAILID:</td>
<td><input name="emailid"/></td>
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