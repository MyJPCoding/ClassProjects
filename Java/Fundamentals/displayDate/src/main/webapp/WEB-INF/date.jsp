<%@ page person="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script><%@include file="js/script.js"%></script>
	<style><%@include file="css/style1.css"%></style>
	<title>Date</title>
</head>
<body>
	<h1 class="date"><c:out value="${date}"/></h1>
</body>
</html>