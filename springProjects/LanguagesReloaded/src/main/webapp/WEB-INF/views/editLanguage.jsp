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
		<form:form method="POST" action="/update_lang" modelAttribute="lang">
			<form:hidden path="id"/>
			<form:label path="name">Name
			<form:input path="name"/>
			</form:label>
			<form:errors path="name" class="red"/>
			<form:label path="creator">Creator
			<form:input path="creator"/>
			</form:label>
			<form:errors path="creator" class="red"/>
			<form:label path="currentVersion">Version
			<form:input path="currentVersion"/>
			</form:label>
			<form:errors path="currentVersion" class="red"/>
			<input type="submit" value="Update"/>
		</form:form>
	</div>
</body>
</html>