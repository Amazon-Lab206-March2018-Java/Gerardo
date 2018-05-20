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
	<title>Login and Registration</title>
</head>
<body>
	<c:if test="${logoutMessage != null}">
       	<c:out value="${logoutMessage}"></c:out>
   	</c:if>
	<div id="wrapper">
		<div id="registration">
			<h1>Register</h1>
			
			<form:form action ="/registration" method="post" modelAttribute = "user">
				<p>
					<form:label path="email">Email
					</form:label>
					<form:input path="email"/>
				</p>
					<form:errors path="email"/>
				<p>
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName"/>
				</p>
					<form:errors path="firstName"/>
				<p>
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName"/>
				</p>
					<form:errors path="lastName"/>
				<p>
					<form:label path="password">Password</form:label>
					<form:password path="password"/>
				</p>
					<form:errors path="password"/>
				<p>
					<form:label path="passwordConfirmation">Confirm Password</form:label>
					<form:password path="passwordConfirmation"/>
				</p>
					<form:errors path="passwordConfirmation"/>
				<input type="submit" value="Register">
			</form:form>
		</div>
		<div id="login">
		<h1>Login</h1>
			<c:if test="${errorMessage != null}">
        		<c:out value="${errorMessage}"></c:out>
    		</c:if>
			<form action="/login" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<p>
					<label for="username">Email:</label>
					<input type="text" name="username">
				</p>
				<p>
					<label for="password">Password:</label>
					<input type="password" name="password">
				</p>
				<input type="submit" name="Login">
			</form>
		</div>
	</div>
</body>
</html>