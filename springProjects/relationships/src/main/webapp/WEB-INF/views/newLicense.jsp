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
		<h1>New License</h1>
		<form:form method="post" action="/licenses/new" modelAttribute="license">
			<form:label path="person">Person
			<form:errors path="person"/>
			<form:select path="person">
				<c:forEach items="${licenseless}" var="persona">
					<form:option value="${persona.id}" label="${persona.firstName} ${persona.lastName}"/>
				</c:forEach>
			</form:select>
			</form:label>
			<form:label path="state">State
			<form:errors path="state"/>
			<form:input path="state"/>
			</form:label>
			<form:label path="expiration_date">Expiration Date
			<form:errors path="expiration_date"/>
			<form:input path="expiration_date" type="date"/>
			</form:label>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>