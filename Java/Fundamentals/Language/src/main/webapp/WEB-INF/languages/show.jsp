<%@ page person="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="http://localhost:8080/persons/delete/${person.id}">Delete</a>
<a href="http://localhost:8080/persons/">Dashboard</a>
<p>person:  <c:out value="${person.name}"/> </p>
<p>Creator:  <c:out value="${person.creator}"/> </p> 
<p>Version:   <c:out value="${person.currentVersion}"/> </p>
</body>
</html>