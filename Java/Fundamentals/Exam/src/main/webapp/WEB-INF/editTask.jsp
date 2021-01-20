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
<h1><c:out value="${task.name}"></c:out></h1>
<!-- new form for editing, only can edit name -->
	<form:form action="/edit-task/${task.id}" method="POST" modelAttribute="task">
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
		<div>
			<button type="submit">Edit Task!</button>
		</div>
	
	</form:form>
	
	<c:if test="${isAssignee == true}">
	<form action="/tasks/${task.id}/delete)">
	<button type="submit">Completed</button>
	</form>
	</c:if>
	

</body>
</html>