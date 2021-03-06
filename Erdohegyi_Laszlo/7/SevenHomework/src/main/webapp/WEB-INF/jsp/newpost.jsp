<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework New Post</title>
        <link rel="stylesheet" type="text/css" href="../../resources/blogstyle.css">
    </head>
    <body>
        <form:form method="post" action="/newpost">
            <label for="author">Name: </label>
            <form:input id="author" path="author" type="text"/>
            <label for="title">Title: </label>
            <form:input id="title" path="title" type="text"/>
            <label for="cont">Comment: </label>
            <form:textarea id="cont" path="content" rows="5" cols="50"/>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>
