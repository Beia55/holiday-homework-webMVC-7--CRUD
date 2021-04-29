<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adauga produs</title>
</head>
<body>
<h1>Add produs</h1>

<form:form action="${pageContext.request.contextPath}/save-add-produs.htm" method="post" modelAttribute="produsForm">
Denumire: <form:input path="denumire"/><br><br>
Pret: <form:input path="pret"/><br><br>
Cantitate: <form:input path="cantitate"/><br>
Culoare: <form:input path="culoare"/><br>
<br>
<input type="submit" value="Salveaza"/><br/>
</form:form>
<br>
<a href="<c:url value="/lista-produse.htm"/>">Back to the list </a>
</body>
</html>