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
		<h1>${idea.content}</h1>
		<p><span>Created By:</span> ${idea.creator.name}</p>
		<h4>Users who liked you idea:</h4>
		<table class="u-full-width">
			<thead>
				<th>Name</th>
			</thead>
			<tbody>
				<c:forEach items="${idea.likedBy}" var="liker">
					<tr>
						<td>${liker.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${ currentUserId == idea.creator.id}">
			<a href="/ideas/${idea.id}/edit" class="button">Edit</a>
		</c:if>
	</div>
</body>
</html>