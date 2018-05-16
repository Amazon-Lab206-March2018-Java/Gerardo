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
		<h1>What is your question</h1>
		<form:form action="/questions/new" method="post" modelAttribute="q">
			<form:label path="question">Question
			<form:errors path="question"/>
			<form:textarea path ="question" rows="3" cols="30"/>
			</form:label>
			<form:label path="strTags">Tags
			<form:errors path="strTags"/>
			<form:input path ="strTags"/>
			</form:label>
			<input type="submit" value="Submit">
		</form:form>
	</div>
</body>
</html>