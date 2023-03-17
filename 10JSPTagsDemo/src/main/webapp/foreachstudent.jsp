<%@ page import="java.util.*,com.jsp.tagdemo.student.Student" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    List<Student> st=new ArrayList<>();
    st.add(new Student("Naveen","HN",false));
    st.add(new Student("Suman","HN",true));
    st.add(new Student("Anil","HV",false));
    st.add(new Student("Sunil","HV",false));
    pageContext.setAttribute("mystudents",st);

    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Discount</th>
</tr>
<c:forEach var="st1" items="${mystudents}">
<tr>
<td>${st1.firstname}</td>
<td>${st1.lastname }</td>
<td>
<c:if test="${st1.above90percent}">
yes
</c:if>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>