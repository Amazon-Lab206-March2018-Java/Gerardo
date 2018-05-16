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
			<a href="/dashboard">Dashboard</a>
		</div>
		<div id="song_info">
			<p><span>Title</span> ${song.name}</p>
			<p><span>Artist</span> ${song.artist}</p>
			<p><span>Rating (1-10)</span>${song.rating}</p>
			<a href="/delete/${song.id}">Delete</a>
		</div>
	</div>
</body>
</html>