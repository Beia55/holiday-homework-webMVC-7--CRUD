<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editare muncitor</title>
</head>
<body>
<h1>Editare muncitor</h1>

<form:form action="${pageContext.request.contextPath}/save-edit-muncitor.htm" method="post" modelAttribute="muncitorForm">
ID: <form:input path="id" readonly = "true"/><br>
Nume: <form:input path="nume"/><br><br>
Varsta: <form:input path="varsta"/><br><br>
Vechime: <form:input path="vechime"/><br>
GrupaMunca: <form:input path="grupaMunca"/><br>
<br>
<input type="submit" value="Salveaza"/><br/>
</form:form>
<br>
<a href="<c:url value="/lista-muncitori.htm"/>">Back to the list </a>

</body>
</html>