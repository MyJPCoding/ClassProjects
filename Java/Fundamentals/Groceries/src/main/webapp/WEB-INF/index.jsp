<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
            <th>Description</th>
            <th>Price</th>
            <th>Category Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out path="${product.name}"/></td>
            <td><c:out path="${product.description}"/></td>
            <td><c:out path="${product.price}"/></td>
            <td><c:out path="${fn:length(product.categories)} "/> Categories</td>
		</tr>
        </c:forEach>
    </tbody>
</table>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Number of Products</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out path="${category.name}"/></td>
            <td><c:out path="${fn:length(category.products)} "/> Products</td>
		</tr>
        </c:forEach>
    </tbody>
</table>


</body>
</html>