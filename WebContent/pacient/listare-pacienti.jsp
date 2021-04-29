<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista pacienti</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Nume</td>
	<td>Adresa</td>
	<td>Varsta</td>
	<td>Diagnostic</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="pc" items="${pacienti}">
	<tr>
		<td><c:out value="${pc.id}"/></td> 
		<td><c:out value="${pc.nume}"/></td>
		<td><c:out value="${pc.adresa}"/></td> 
		<td><c:out value="${pc.varsta}"/></td>
		<td><c:out value="${pc.diagnostic}"/></td>
		<td>
			<a href="<c:url value="/detalii-pacient.htm?id=${pc.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-pacient.htm?id=${pc.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-pacient.htm?id=${pc.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-pacient.htm"/>">Add pacient</a>
</body>
</html>