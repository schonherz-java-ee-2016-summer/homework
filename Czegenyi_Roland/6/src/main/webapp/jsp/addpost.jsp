<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/index-servlet" method="post" id="blogForm">
    Title: <input type="text" name="TITLE">
    Author name <input type="text" name="AUTHOR_NAME"></br>
    Story <textarea name="CONTENT" rows="5" cols="20"></textarea></br>
    <input type="submit" name="Submit">
</form>

</body>
</html>
