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
<a href="http://localhost:8080/logout">Logout</a>
<!-- for each item in teams, post name, id, each hero in team -->
<table>
    <thead>
        <tr>
            <th>Task</th>
            <th>Creator</th>
            <th>Assignee</th>
            <th>Priority</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${tasks}" var="task">
        		<tr>
		           <td><a href="http://localhost:8080/tasks/${task.id}"> <c:out value="${task.name}"></c:out></a></td>
				   <td><c:out value="${task.creator.getName()}"></c:out></td>
					<td><c:out value="${task.assignee.getName()}"></c:out></td>
					<td><c:out value="${task.priority}"></c:out></td>
				</tr>	
        </c:forEach>
    </tbody>
</table>
<br>
<br>
<form action="/tasks/new" method="get">
	<button type="submit"> Create Task</button>
</form>





	<c:forEach items="${tasks}" var="task">
		
	</c:forEach>
</body>
</html>