<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editare director</title>
</head>
<body>
<h1>Editare director</h1>

<form:form action="${pageContext.request.contextPath}/save-edit-director.htm" method="post" modelAttribute="directorForm">
ID: <form:input path="id" readonly = "true"/><br>
Nume: <form:input path="nume"/><br><br>
Varsta: <form:input path="varsta"/><br><br>
Telefon: <form:input path="telefon"/><br>
Salar: <form:input path="salar"/><br>
<br>
<input type="submit" value="Salveaza"/><br/>
</form:form>
<br>
<a href="<c:url value="/lista-directori.htm"/>">Back to the list </a>

</body>
</html>