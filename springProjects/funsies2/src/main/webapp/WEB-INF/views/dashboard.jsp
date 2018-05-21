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
	<script
		src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
	</script>
	<script src="js/script.js"></script>
	<title>Dashboard</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Welcome, ${ currentUser.name }</h1>
			<form id="logoutForm" method="POST" action="/logout">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<a href="#" class="logout">Logout</a>
			</form>
		</div>
		<div id="over_table">
			<h3>Ideas</h3> <a href="#">Low Likes</a><span>     </span><a href="#">High Likes</a>
		</div>
		<table class = "u-full-width">
			<thead>
				<tr>
					<th>Idea</th>
					<th>Created By</th>
					<th>Likes</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items = "${ideasList}" var = "idea">
					<tr>
						<td><a href="/ideas/${idea.id}">${idea.content}</a></td>
						<td>${idea.creator.name}</td>
						<td>${idea.likedBy.size()}</td>
						<td><a href="/ideas/${idea.id}/like">
						<c:if test="${ !idea.likedBy.contains(currentUser) }">
							Like
						</c:if>
						<c:if test="${ idea.likedBy.contains(currentUser) }">
							Unlike
						</c:if>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/ideas/new" class="button">Create an Idea</a>
	</div>
</body>
</html>