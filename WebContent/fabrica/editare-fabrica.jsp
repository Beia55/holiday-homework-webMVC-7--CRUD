<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editare fabrica</title>
</head>
<body>
<h1>Editare fabrica</h1>

<form:form action="${pageContext.request.contextPath}/save-edit-fabrica.htm" method="post" modelAttribute="fabricaForm">
ID: <form:input path="id" readonly = "true"/><br>
Denumire: <form:input path="denumire"/><br><br>
Industrie: <form:input path="industrie"/><br><br>
Adresa: <form:input path="adresa"/><br>
<br>
<input type="submit" value="Salveaza"/><br/>
</form:form>
<br>
<a href="<c:url value="/lista-fabrici.htm"/>">Back to the list </a>

</body>
</html>