<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Create a Category</h1>

<c:out value="${error}"></c:out>

<form:form action="/products" method="POST" modelAttribute="product">
		<div>
			
			<form:label path="name">Name:</form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		<div>
			
			<form:label path="description">description:</form:label>
			<form:errors path="description"></form:errors>
			<form:input path="description"></form:input>
		</div>
		<div>
			
			<form:label path="price">Price: $</form:label>
			<form:errors path="price"></form:errors>
			<form:input path="price"></form:input>
		</div>
		<div>
			<button type="submit">Create a Product!</button>
		</div>
	</form:form>

</body>
</html>