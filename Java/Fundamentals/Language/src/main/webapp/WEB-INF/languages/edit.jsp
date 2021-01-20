<%@ page person="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/persons/edit/${person.id}" method="POST" modelAttribute="person">

 Name: <form:input path="name" value="${person.name}" ></form:input>
 Creator: <form:input path="creator" value='${person.creator}' ></form:input>
 Version: <form:input path="currentVersion" value='${person.currentVersion}' ></form:input>
 
 <input type="submit" value="Submit"/>
 </form:form>
 
<a href="http://localhost:8080/persons/delete/${person.id}">Delete</a>
<a href="http://localhost:8080/persons/">Dashboard</a>
</body>
</html>