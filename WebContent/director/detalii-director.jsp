<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii director</title>
</head>
<body>

<h1>Detalii director</h1>
ID: <td><c:out value="${director.id}"/></td> </br>
Nume: <td><c:out value="${director.nume}"/></td> </br>
Varsta: <td><c:out value="${director.varsta}"/></td> </br>
Telefon: <td><c:out value="${director.telefon}"/></td> </br>
Salar: <td><c:out value="${director.salar}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-directori.htm"/>">Back to the list</a></table>

</body>
</html>