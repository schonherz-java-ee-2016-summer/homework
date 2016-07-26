<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Add new blogpost - Simple Blog Webapp - </title>
    <link rel="stylesheet" type="text/css" href="/css/styleSheet.css"/>
</head>
<body>
    <h1>Simple Blog Webapp</h1>
    <div>
        <form method="post" action="/index-servlet">
            <input name="author" type="text" placeholder="Your name..."><br>
            <input name="title" type="text" placeholder="Title of your post..."><br>
            <textarea name="content" rows="10" cols="50" placeholder="Enter your blogpost here..."></textarea><br>
            <button class="button" name="submitNewPost" type="submit">Submit post</button><br>
        </form>
    </div>
</body>
</html>
