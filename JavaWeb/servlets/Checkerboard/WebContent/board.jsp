<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/board.css" rel="stylesheet" type="text/css">
	<title>Checker Board</title>
</head>
<body>
	<%
		int rows = Integer.parseInt(request.getParameter ("rows"));
		int columns = Integer.parseInt(request.getParameter ("columns")); 
	%>
	<h1> Checker Board <%= rows %> X <%= columns %></h1>
	<% for (int i = 0; i<rows; i++) {
		%><div id="container"><%
		if (i%2 == 0) {
			for (int j=1; j<=columns; j++) {
				if (j%2 == 1) { %>
					<div class = "square purple"></div>
				<% } else { %>
					<div class = "square blue"></div>
				<% } %>
			<% } %>
		<% } else { %>
			<% for (int j=0; j<columns; j++) {
				   if (j%2 == 1) { %>
				   		<div class = "square purple"></div>
				   <% } else { %>
			       		<div class = "square blue"></div>
				   <% } %>
			<% } %>
		<% } %>
		</div>
	<% } %>

</body>
</html>