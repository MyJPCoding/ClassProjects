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
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="http://localhost:8080/languages/${language.id}"> <c:out value="${language.name}"/></a> </td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td><a href="http://localhost:8080/languages/delete/${language.id}"> Delete</a> </td>
            <td><a href="http://localhost:8080/languages/edit/${language.id}"> Edit </a> </td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/languages" method="POST" modelAttribute="language">

Name: <form:input path="name"></form:input>
<br>
Creator <form:input path="creator"></form:input>
<br>
Version: <form:input path="currentVersion"></form:input>
<br>
<input type="submit" value="Submit"/>

</form:form>
</body>
</html>