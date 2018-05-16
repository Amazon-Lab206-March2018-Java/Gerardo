<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
        <%@include file="../css/skeleton.css" %>
        <%@include file="../css/normalize.css" %>
        <%@include file="../css/style.css" %>
	</style>
	<title></title>
</head>
<body>
	<div id="wrapper">
		<h1>New Product</h1>
		<form:form action="/products/new" method="post" modelAttribute="product">
			<form:label path="name">Name
			<form:errors path="name"/>
			<form:input path="name"/>
			</form:label>
			<form:label path="description">Description
			<form:errors path="description"/>
			<form:textarea path="description" rows="3" cols="30"/>
			</form:label>
			<form:label path="price">Price
			<form:errors path="price"/>
			<form:input path="price"/>
			</form:label>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>