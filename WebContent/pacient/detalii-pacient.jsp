<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii pacient</title>
</head>
<body>

<h1>Detalii pacient</h1>
ID: <td><c:out value="${pacient.id}"/></td> </br>
Nume: <td><c:out value="${pacient.nume}"/></td> </br>
Adresa: <td><c:out value="${pacient.adresa}"/></td> </br>
Varsta: <td><c:out value="${pacient.varsta}"/></td> </br>
Diagnostic: <td><c:out value="${pacient.diagnostic}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-pacienti.htm"/>">Back to the list</a></table>

</body>
</html>