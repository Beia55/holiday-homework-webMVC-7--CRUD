<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista spitale</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Nume</td>
	<td>Adresa</td>
	<td>Telefon</td>
	<td>Email</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="sp" items="${spitale}">
	<tr>
		<td><c:out value="${sp.id}"/></td> 
		<td><c:out value="${sp.nume}"/></td>
		<td><c:out value="${sp.adresa}"/></td> 
		<td><c:out value="${sp.telefon}"/></td>
		<td><c:out value="${sp.email}"/></td>
		<td>
			<a href="<c:url value="/detalii-spital.htm?id=${sp.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-spital.htm?id=${sp.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-spital.htm?id=${sp.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-spital.htm"/>">Add spital</a>
</body>
</html>