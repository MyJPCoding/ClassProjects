<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create Task!</h1>
<!--  starts form, all that is need is the name -->
	<form:form action="/create-task" method="POST" modelAttribute="task">
		<div>
			<p>Task:</p>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		<div>
			<c:if test="${tooManyTasks == true}">
				<p>That user has too many tasks. Please select another user.</p>
			</c:if>
			<form:select path="assignee">
				<c:forEach items="${users}" var="user">
					<form:option value="${user}">${user.name}</form:option>
				</c:forEach>
			</form:select>				
		</div>
		<div>
			<form:select path="priority">
				<form:option value="Low">Low</form:option>
				<form:option value="Medium">Medium</form:option>
				<form:option value="High">High</form:option>
			</form:select>				
		</div>
		<p>
			<button type="submit">Create a team!</button>
		</p>
	
	</form:form>
<!-- 	edit team by id, and delete team by id, shows all teams -->
	<c:forEach items="${teams}" var="team">
<!-- 	c if statement if changing based upon user -->
		<p><c:out value="${team.name}"></c:out></p>
		<p><a href="/edit-team/${team.id}">Edit!</a></p>
<!-- 		NEW FORM HERE for delete -->
		<form action="/delete-team/${team.id}" method="POST">
			<button type="submit">Delete this team!</button>
		</form>
	</c:forEach>
</body>
</html>