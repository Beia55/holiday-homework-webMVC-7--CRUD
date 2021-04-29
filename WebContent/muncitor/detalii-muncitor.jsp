<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii muncitor</title>
</head>
<body>

<h1>Detalii muncitor</h1>
ID: <td><c:out value="${spital.id}"/></td> </br>
Nume: <td><c:out value="${spital.nume}"/></td> </br>
Varsta: <td><c:out value="${spital.varsta}"/></td> </br>
Vechime: <td><c:out value="${spital.vechime}"/></td> </br>
GrupaMunca: <td><c:out value="${spital.grupaMunca}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-muncitori.htm"/>">Back to the list</a></table>

</body>
</html>