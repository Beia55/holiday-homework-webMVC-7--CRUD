<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii Fabrica</title>
</head>
<body>

<h1>Detalii Fabrica</h1>
ID: <td><c:out value="${fabrica.id}"/></td> </br>
Denumire: <td><c:out value="${fabrica.denumire}"/></td> </br>
Industrie: <td><c:out value="${fabrica.industrie}"/></td> </br>
Adresa: <td><c:out value="${fabrica.adresa}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-fabrici.htm"/>">Back to the list</a></table>

</body>
</html>