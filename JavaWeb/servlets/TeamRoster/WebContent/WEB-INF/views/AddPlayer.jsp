<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <title>Add player</title>
</head>
<body>
    <p>Add a player to team <c:out value="${team.getTeamName()}"/></p>
    <form action="add_player" method="post">
        <p>
            <label for="firstName">First Name </label>
            <input type="text" name="firstName">
        </p>
        <p>
            <label for="lastName">Last Name</label>
            <input type="text" name="lastName">
        </p>
        <p>
            <label for="age">Age</label>
            <input type="number" name = "age" min="1">
        </p>
        <input type="submit" value="Add">
    </form>
</body>
</html>