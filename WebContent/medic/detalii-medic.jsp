<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii medic</title>
</head>
<body>

<h1>Detalii Medic</h1>
ID: <td><c:out value="${medic.id}"/></td> </br>
Nume: <td><c:out value="${medic.nume}"/></td> </br>
Specialitate: <td><c:out value="${medic.specialitate}"/></td> </br>
Vechime: <td><c:out value="${medic.vechime}"/></td> </br>
Salar: <td><c:out value="${medic.salar}"/></td> </br>
<br></br>
<a href="<c:url value="/lista-medici.htm"/>">Back to the list</a></table>

</body>
</html>