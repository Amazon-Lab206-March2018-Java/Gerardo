<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
        <form action="/result" method="post">
            <p>
                <label for="name">Your Name</label>
                <input type="text" name="name">
            </p>
            <p>
                <label for="location">Dojo Location</label>
                <select name="location">
                    <option value="San Jose">San Jose</option>
                    <option value="Arizonna"></option>
                </select>
            </p>
            <p>
                <label for="favLang">Favorite Language</label>
                <select name="favLang">
                    <option value="Python">Python</option>
                    <option value="Java">Java</option>
                    <option value="C++">C++</option>
                </select>
            </p>
            <p>
                <label for="comment">Comment (optional)</label>
                <textarea name="comment" cols="30" rows="3"></textarea>
            </p>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>