<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
        /* <%@include file="../css/skeleton.css" %>
        <%@include file="../css/normalize.css" %>
        <%@include file="../css/style.css" %> */
	</style>
	<title></title>
</head>
<body>
	<div id="wrapper">
		<h1>${product.name}</h1>
		<div id="categories">
			<h5>Categories</h5>
			<ul>
				<c:forEach items="${product.categories}" var="category">
					<li>${category.name}</li>
				</c:forEach>
			</ul>
		</div>
		<form action="/products/assign_category" method="post">
			<input type="hidden" name="prod_id" value="${product.id}">
			<p>
				<label for="cat_id">Add Category</label>
				<select name="cat_id" >
					<c:forEach items="${category_list}" var="category">
					<option value='${category.id}'>${category.name}</option>
					</c:forEach>
				</select>
			</p>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>