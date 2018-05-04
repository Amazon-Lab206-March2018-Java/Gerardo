<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style type="text/css">
        <%@include file="css/style.css" %>
        <%@include file="css/skeleton.css" %>
        <%@include file="css/normalize.css" %>
    </style>
    <title>Ninja Gold</title>
</head>
<body>
    <div id="wrapper">
        <p>
            <label for="gold">Your Gold: </label>
            <input type="text" name="gold" value='<c:out value="${ gold }"/>' readonly>
        </p>
        <div id="box_holder">
            <div class="location">
                <h3>Farm</h3>
                <p>(earns 10-20 golds)</p>
                <form action="/get_money" method='post'>
                    <input type="hidden" name='money_source' value="farm">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="location">
                <h3>Cave</h3>
                <p>(earns 5-10 golds)</p>
                <form action="/get_money" method='post'>
                    <input type="hidden" name='money_source' value="cave">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="location">
                <h3>House</h3>
                <p>(earns 2-5 golds)</p>
                <form action="/get_money" method='post'>
                    <input type="hidden" name='money_source' value="house">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="location">
                <h3>Casino</h3>
                <p>(earns/takes 0-50 golds)</p>
                <form action="/get_money" method='post'>
                    <input type="hidden" name='money_source' value="casino">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
        </div>
        <div id="history_holder">
            <p> Activities:</p>
            <div id="history">
				<c:forEach var = "element" items = "${ history }">
				<c:out value="${ element }" escapeXml="false"/>
				</c:forEach>
            </div>
            <form action="/clear">
                <input type="submit" value="Clear">
            </form>
        </div>
    </div>
</body>
</html>