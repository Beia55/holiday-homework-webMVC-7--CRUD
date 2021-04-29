<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista fabrici</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Denumire</td>
	<td>Industrie</td>
	<td>Adresa</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="fab" items="${fabrici}">
	<tr>
		<td><c:out value="${fab.id}"/></td> 
		<td><c:out value="${fab.denumire}"/></td>
		<td><c:out value="${fab.industrie}"/></td> 
		<td><c:out value="${fab.adresa}"/></td>
		<td>
			<a href="<c:url value="/detalii-fabrica.htm?id=${fab.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-fabrica.htm?id=${fab.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-fabrica.htm?id=${fab.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-fabrica.htm"/>">Add fabbrica</a>
</body>
</html>