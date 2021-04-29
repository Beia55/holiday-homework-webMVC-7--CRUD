<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Directori</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Nume</td>
	<td>Varsta</td>
	<td>Telefon</td>
	<td>Salar</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="dir" items="${directori}">
	<tr>
		<td><c:out value="${dir.id}"/></td> 
		<td><c:out value="${dir.nume}"/></td>
		<td><c:out value="${dir.varsta}"/></td> 
		<td><c:out value="${dir.telefon}"/></td>
		<td><c:out value="${dir.salar}"/></td>
		<td>
			<a href="<c:url value="/detalii-director.htm?id=${dir.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-director.htm?id=${dir.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-director.htm?id=${dir.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-director.htm"/>">Add director</a>
</body>
</html>