<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<form:form action="/ninjas" method="POST" modelAttribute="ninja">
<h5>Dojo: <form:select path="dojo">
<c:forEach items="${dojos}" var="dojo">
<form:option value="${dojo}">${dojo.name}</form:option>
</c:forEach>
</form:select> 
</h5>
<h5>First Name: <form:input path="firstName"/>  </h5>
<h5>Last Name: <form:input path="lastName"/> </h5>
<h5>Age: <form:input path="age"/> </h5>
<input type="submit" value="Create"/>
</form:form>
</body>
</html>