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
		<div id="navigation">
			<a href="/songs/new">Add new</a>
			<a href="/search/topTen">Top Songs</a>
			<form action="/search">
				<input type="text" name="search_term">
				<input type="submit" value="Search Artists">
			</form>
		</div>
		<table class="u-full-width">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.name}</a></td>
					<td>${song.rating}</td>
					<td><a href="/delete/${song.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>