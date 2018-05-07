<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    /* <%@include file="../css/skeleton.css" %>
    <%@include file="../css/normalize.css" %>
    <%@include file="../css/style.css" %> */
</style>
<title>Fortran dashboard</title>
</head>
<body>
    <mytags:navbar/>
    <div id="wrapper">
        <form action="">
            <textarea name="" cols="30" rows="5"><c:out value="${content}"/></textarea>
        </form>
    </div>
</body>
</html>