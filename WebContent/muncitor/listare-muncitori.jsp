<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista muncitori</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Nume</td>
	<td>Varsta</td>
	<td>Vechime</td>
	<td>GrupaMunca</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="mc" items="${muncitori}">
	<tr>
		<td><c:out value="${mc.id}"/></td> 
		<td><c:out value="${mc.nume}"/></td>
		<td><c:out value="${mc.varsta}"/></td> 
		<td><c:out value="${mc.vechime}"/></td>
		<td><c:out value="${mc.grupaMunca}"/></td>
		<td>
			<a href="<c:url value="/detalii-muncitor.htm?id=${mc.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-muncitor.htm?id=${mc.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-muncitor.htm?id=${mc.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-muncitor.htm"/>">Add muncitor</a>
</body>
</html>