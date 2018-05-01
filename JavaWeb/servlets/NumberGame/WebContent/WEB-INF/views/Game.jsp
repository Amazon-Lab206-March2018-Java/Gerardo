<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style type="text/css">
        <%@include file="../css/style.css" %>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <title>Great Number Game</title>
</head>
<body>
    <div id="wrapper" class="text-center p-2">
        <h1>Welcome to the Great Number Game!</h1>
        <p>I'm thinking of a number between 1 and 100</p>
        <p>Take a guess!</p>
        <c:choose>
            <c:when test = "${result == -1}">
                <div class="square red">
                    <p>Too low!</p>
                </div>
                <form action="guess" method="post">
                        <input type="text" name="numberGuess">
                        <input type="submit" value="Submit">
                </form>
            </c:when>
            <c:when test = "${result == 1}">
                <div class="square red">
                    <p>Too high!</p>
                </div>
                <form action="guess" method="post">
                        <input type="text" name="numberGuess">
                        <input type="submit" value="Submit">
                </form>
            </c:when>
            <c:when test = "${result == 0}">
                <div class="square green">
                    <p><c:out value="${game.getRandomNumber()}"/> was the number!</p>
                    <form action="reset" method="post">
                        <input type="submit" value="Play again!">
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <form action="guess" method="post">
                        <input type="text" name="numberGuess">
                        <input type="submit" value="Submit">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>