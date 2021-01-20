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

<h1>${product.name}</h1>
<h4>${product.description}</h4>
<h4>${product.price}</h4>



Current Categories
<c:forEach items="${product.categories}" var="category">
<p>${category.name}</p>
</c:forEach>

Would you like to add a Product to your category?
<form:form action="/addCategoryToProduct" method="POST" modelAttribute="categoryProduct">
		<div>
			<p>Tags:</p>
			<form:label path="category"></form:label>
			<form:errors path="category"></form:errors>
			<form:select path="category">
				<option value="" disabled selected>Select a category!</option>
				<c:forEach items="${categories}" var="category">
					<form:option value="${category.id}">
						<c:out value="${category.name}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<button type="submit">Add the category!</button>
		</div>
	
	
	</form:form>
</body>
</html>