<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editare pacient</title>
</head>
<body>
<h1>Editare pacient</h1>

<form:form action="${pageContext.request.contextPath}/save-edit-pacient.htm" method="post" modelAttribute="pacientForm">
ID: <form:input path="id" readonly = "true"/><br>
Nume: <form:input path="nume"/><br><br>
Adresa: <form:input path="adresa"/><br><br>
Varsta: <form:input path="varsta"/><br>
Diagnostic: <form:input path="diagnostic"/><br>
<br>
<input type="submit" value="Salveaza"/><br/>
</form:form>
<br>
<a href="<c:url value="/lista-pacienti.htm"/>">Back to the list </a>

</body>
</html>