<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Information</h1>
<table>
    <thead>
        <tr>
            <th>Dojo Name</th>
            <th>Dojo Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dojos}" var="dojo">
        <tr>
            <td><c:out path="${dojo.name}"/></td>
            <td><c:out path="${fn:length(dojo.ninjas)} "/> Ninjas</td>
		</tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>