<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div id="wrapper">
        <p>Submitted Info</p>
        <p><span>Name: </span> <c:out value="${name}"/></p>
        <p><span class="space">Dojo Location: </span> <c:out value="${location}"/></p>
        <p><span class="space">Favorite Language: </span> <c:out value="${favLang}"/></p>
        <p><span class="space">Comment: </span> <c:out value="${comment}"/></p>
    </div>
    <a href="/"><button>Go Back</button></a>
</body>
</html>