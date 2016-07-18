<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add new post</title>
    <link rel="stylesheet" href="style.css">

</head>
    <body>
    <form method="post" action="/blog/addPost">
        <label for="user">Username:</label>
        <input id="user" name="user" type="text">
        <label for="title">Title:</label>
        <input id="title" name="title" type="text">
        <label for="Content">Content:</label>
        <input id="content" name="content" type="text" rows="5">
        <button type="submit">OK</button>
    </form>
    </body>
</html>
