<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add new post</title>
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="javascript.js"></script>
</head>
    <body>
    <%@include file="/html/header.html"%>
    <form id="addPost" method="post" action="/blog/blogPostServlet"  onsubmit="return validatePost()">
        <div id="inputFields">
            <div><h2>Add a new post!</h2></div>
            <div><label for="user">Author name:</label></div>
            <div><input id="user" name="user" type="text"></div>
            <div><label for="title">Title:</label></div>
            <div><input id="title" name="title" type="text"></div>
            <div>Content:</div>
            <div><textarea name="content" rows="10" cols="50"></textarea></div>
            <div><button type="submit">Add the post</button></div>
        </div>
    </form>
    </body>
</html>
