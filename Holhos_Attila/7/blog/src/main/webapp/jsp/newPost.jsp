<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add new post</title>
    <link rel="stylesheet" href="/blog/css/style.css">
    <script type="text/javascript" src="/blog/js/javascript.js"></script>
</head>
    <body>
    <%@include file="/html/header.html"%>
    <form:form modelAttribute="post" id="addPost" method="post" action="/post/new"  onsubmit="return validatePost()">
        <div id="inputFields">
            <div><h2>Add a new post!</h2></div>
            <div><label for="author"> Author name:</label></div>
            <div><form:input path="author"/></div>
            <div><label for="title">Title:</label></div>
            <div><form:input path="title"/></div>
            <div>Content:</div>
            <div><form:textarea path="content" rows="10" cols="50"></form:textarea></div>
            <div><button type="submit">Add the post</button></div>
        </div>
    </form:form>
    </body>
</html>
