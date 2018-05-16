<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
        /* <%@include file="../css/skeleton.css" %>
        <%@include file="../css/normalize.css" %>
        <%@include file="../css/style.css" %> */
	</style>
	<title></title>
</head>
<body>
	<div id="wrapper">
		<h1>${question.question}</h1>
		<div id="tagged">
			<h5>Tags: </h5>
			<p>
				<c:forEach items="${question.tags}" var = "tag">
					<span>${tag.subject} </span>
				</c:forEach>
			</p>
		</div>
		<div id="content">
			<table class="u-full-width">
				<thead>
					<tr>
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${question.answers}" var="ans">
						<tr>
							<td>${ans.answer}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="answer_form">
				<h4>Add you answer</h4>
				<form:form action="/questions/${question.id}/new_answer" method="post" modelAttribute="ans">
					<form:hidden path="question" value="${question.id}"/>
					<form:label path="answer">Answer
					<form:errors path="answer"/>
					<form:textarea path="answer" rows="4" cols="30"/>
					</form:label>
					<input type="submit" value="Answer it!">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>