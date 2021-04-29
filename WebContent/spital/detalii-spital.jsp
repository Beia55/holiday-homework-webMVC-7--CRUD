<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii spital</title>
</head>
<body>

<h1>Detalii spital</h1>
ID: <td><c:out value="${spital.id}"/></td> </br>
Nume: <td><c:out value="${spital.nume}"/></td> </br>
Adresa: <td><c:out value="${spital.adresa}"/></td> </br>
Telefon: <td><c:out value="${spital.telefon}"/></td> </br>
Email: <td><c:out value="${spital.email}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-spitale.htm"/>">Back to the list</a></table>

</body>
</html>