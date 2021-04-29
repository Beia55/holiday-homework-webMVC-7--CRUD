<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii produs</title>
</head>
<body>

<h1>Detalii produs</h1>
ID: <td><c:out value="${produs.id}"/></td> </br>
Denumire: <td><c:out value="${produs.denumire}"/></td> </br>
Pret: <td><c:out value="${produs.pret}"/></td> </br>
Cantitate: <td><c:out value="${produs.cantitate}"/></td> </br>
Culoare: <td><c:out value="${produs.culoare}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-produse.htm"/>">Back to the list</a></table>

</body>
</html>