<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adauga Medic</title>
</head>
<body>
<h1>Add Medic</h1>

<form:form action="${pageContext.request.contextPath}/save-add-medic.htm" method="post" modelAttribute="medicForm">
Nume: <form:input path="nume"/><br><br>
Specialitate: <form:input path="specialitate"/><br><br>
Vechime: <form:input path="vechime"/><br>
Salar: <form:input path="salar"/><br>
<br>
<input type="submit" value="Salveaza"/><br/>
</form:form>
<br>
<a href="<c:url value="/lista-medici.htm"/>">Back to the list </a>
</body>
</html>