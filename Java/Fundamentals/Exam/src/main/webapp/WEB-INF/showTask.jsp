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
<h1>${task.name}</h1>
<!-- new form for editing, only can edit name -->

<h4>Creator: <c:out value="${task.creator.getName()}"></c:out></h4>
<h4>Assignee: <c:out value="${task.assignee.getName()}"></c:out></h4>
<h4>Priority: <c:out value="${task.priority}"></c:out></h4>	

<div>
<form action="/tasks/${task.id}/edit">
<button type="submit">Edit Task</button>
</form>

<form action="/tasks/${task.id}/delete">
<button type="submit">Delete Task</button>
</form>
</div>

</body>
</html>