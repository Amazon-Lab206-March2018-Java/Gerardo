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
		<h1>Welcome "${ currentUser.firstName }"</h1>
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <a href="#" class="logout">Logout</a>
    	</form>
		<div id="user_info">
			<p><span>First Name:</span> ${currentUser.firstName}</p>
			<p><span>Last Name:</span> ${currentUser.lastName}</p>
			<p><span>Email:</span> ${currentUser.email}</p>
			<p><span>Sign up date:</span> ${currentUser.createdAt}</p>
			<p><span>Last Sign in:</span> ${currentUser.lastSignIn}</p>
		</div>
	</div>
</body>
</html>