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
		<div>
			<p>Make a Dog!</p>
			<form action = "dog" method="post">
				<label for="name">Name</label>
				<input type="text" name="name">
				<label for="breed">Breed</label>
				<input type="text" name="breed">
				<label for="weight">Weight</label>
				<input type="text" name="weight">
				<input type="submit" value="Submit">
			</form>
		</div>
		<div>
			<p>Make a Cat!</p>
			<form action = "cat" method="post">
				<label for="name">Name</label>
				<input type="text" name="name">
				<label for="breed">Breed</label>
				<input type="text" name="breed">
				<label for="weight">Weight</label>
				<input type="text" name="weight">
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
</body>
</html>