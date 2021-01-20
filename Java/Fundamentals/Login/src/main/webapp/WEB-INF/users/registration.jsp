<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
    <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
<!--     USER SPECIFIC HERE -->
    	<c:forEach items="${teams}" var="team">
	<c:if test="${team.getUser().getId() == user.getId() }">
		<hr>
		<p>name: <c:out value="${team.name}"></c:out>
		<p>id: <c:out value="${team.id}"></c:out>
<!-- 		Call Method for getting entries -->
		<c:forEach items="${team.getHeroes()}" var="hero">
			<p>name: <c:out value="${hero.name}"></c:out></p>
			<p>id: <c:out value="${hero.id}"></c:out></p>
		</c:forEach>
	</c:if>
	</c:forEach>
    
</body>
</html>