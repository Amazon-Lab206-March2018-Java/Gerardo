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
		<h1>${category.name}</h1>
		<div id="products">
			<h5>Products</h5>
			<ul>
				<c:forEach items="${category.products}" var="product">
				<li>"${product.name}"</li>
				</c:forEach>
			</ul>
		</div>
		<form action="/categories/assign_product" method="post">
			<input type="hidden" name="cat_id" value="${category.id}">
			<p>
				<label for="prod_id">Add Product</label>
				<select name="prod_id" >
					<c:forEach items="${product_list}" var="product">
					<option value='${product.id}'>${product.name}</option>
					</c:forEach>
				</select>
			</p>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>