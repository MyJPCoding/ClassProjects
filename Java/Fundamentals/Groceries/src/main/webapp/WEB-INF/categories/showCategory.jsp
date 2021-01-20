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

<h1>${category.name}</h1>

Would you like to add a Product to your category?
	<form action="/addProductToCategory" method="POST">
		<div>
		
			<label>Product</label>
			<select name="product_IDENTIFICATION">
				<option value="" disabled selected>Select a Product!</option>
				<c:forEach items="${products}" var="product">
					<option value="${product.id}">
						<c:out value="${product.name}"></c:out>
					</option>
				</c:forEach>
				
			</select>
			<input hidden="true" value="${category.id}" name="category_id"/>
		</div>
		<div>
			<button type="submit">Add the product!</button>
		</div>	
	</form>
</body>
</html>