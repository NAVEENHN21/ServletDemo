<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% java.util.Date mydate=new java.util.Date(); %>

Time on the server is <%= new java.util.Date() %>

Mydate <%= mydate %>

<br/>

Mydate2= ${mydate}

</body>
</html>