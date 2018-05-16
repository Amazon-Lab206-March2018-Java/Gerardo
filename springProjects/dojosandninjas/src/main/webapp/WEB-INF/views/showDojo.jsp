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
		<h1>${dojo.name} Location Ninjas</h1>
		<table class="u-full-width">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="ninja">
					<tr>
						<td>${ninja.firstName}</td>
						<td>${ninja.lastName}</td>
						<td>${ninja.age}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>