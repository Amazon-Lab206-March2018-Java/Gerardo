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
		<navigation>
			<a href="/dashboard">Dashboard</a>
		</navigation>
		<form:form method="POST" action="/songs/new" modelAttribute="song">
			<form:label path="name">Title
			<form:input path="name"/>
			<form:errors path="name" class="red"/>
			</form:label>
			<form:label path="artist">Artist
			<form:input path="artist"/>
			<form:errors path="artist" class="red"/>
			</form:label>
			<form:label path="rating">Rating (1-10)
			<form:input path="rating"/>
			<form:errors path="rating" class="red"/>
			</form:label>
			<input type="submit" value="Add Song"/>
		</form:form>
	</div>
</body>
</html>