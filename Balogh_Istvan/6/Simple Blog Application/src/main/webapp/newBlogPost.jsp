<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Add new blogpost - Simple Blog Webapp - </title>
</head>
<body>
    <h1 align="center">Simple Blog Webapp</h1>
    <div align="center">
        <form method="post" action="/index-servlet">
            <label for="name">Your name</label>
            <input id="name" name="name" type="text"><br>
            <textarea id="textarea" rows="10" cols="50" placeholder="Enter your blogpost here..."></textarea><br>
            <button id="submitNewPost" name="submitNewPost" type="submit">Submit post</button><br>
        </form>
    </div>
</body>
</html>
