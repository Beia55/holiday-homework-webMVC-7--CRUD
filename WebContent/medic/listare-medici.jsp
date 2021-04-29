<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Medici</title>
</head>
<body>

<table border=1>
<tr>
	<td>ID</td>
	<td>Nume</td>
	<td>Specialitate</td>
	<td>Vechime</td>
	<td>Salar</td>
	<td>Actiuni</td>
</tr>
<c:forEach var="med" items="${medici}">
	<tr>
		<td><c:out value="${med.id}"/></td> 
		<td><c:out value="${med.nume}"/></td>
		<td><c:out value="${med.specialitate}"/></td> 
		<td><c:out value="${med.vechime}"/></td>
		<td><c:out value="${med.salar}"/></td>
		<td>
			<a href="<c:url value="/detalii-medic.htm?id=${med.id}"/>">Details</a><br>
			<a href="<c:url value="/delete-medic.htm?id=${med.id}"/>">Delete</a><br>		
			<a href="<c:url value="/edit-medic.htm?id=${med.id}"/>">Edit</a>	
		</td>
	</tr>
</c:forEach>
</table>
<br><br>
	<a href="<c:url value="/add-medic.htm"/>">Add Medic</a>
</body>
</html>