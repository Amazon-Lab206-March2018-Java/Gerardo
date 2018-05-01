<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Stop Watch</title>
</head>
<body>
	<navigation>
        <a href="start">Start</a> <a href="stop">Stop</a> <a href="reset">Reset</a>
    </navigation>
    <div id="wrapper">
        <div id="timers">
            <p>Start: <c:out value="${ startTime }"/></p>
            <p>Current Time: <c:out value="${ currentTime }"/></p>
            <p>Running Time: <c:out value="${ runningTime }"/></p>
        </div>
        <table class ="table-striped">
            <thead>
                <th>Start</th>
                <th>Stop</th>
                <th>Total</th>
            </thead>
            <tbody>
                <c:forEach items="${ timeList }" var="list">
            </tbody>
        </table>
    </div>
</body>
</html>