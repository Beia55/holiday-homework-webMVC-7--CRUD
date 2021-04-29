<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista produse</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Denumire</td>
	<td>Pret</td>
	<td>Cantitate</td>
	<td>Culoare</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="pr" items="${produse}">
	<tr>
		<td><c:out value="${pr.id}"/></td> 
		<td><c:out value="${pr.denumire}"/></td>
		<td><c:out value="${pr.pret}"/></td> 
		<td><c:out value="${pr.cantitate}"/></td>
		<td><c:out value="${pr.culoare}"/></td>
		<td>
			<a href="<c:url value="/detalii-produs.htm?id=${pr.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-produs.htm?id=${pr.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-produs.htm?id=${pr.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-produs.htm"/>">Add produs</a>
</body>
</html>