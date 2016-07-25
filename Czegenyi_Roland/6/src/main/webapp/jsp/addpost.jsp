<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add a new post.</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>

<p class="title">Simple Blog</p>


<form action="/index-servlet" method="post" id="blogForm">
    <fieldset class="new">
        <label>Title: </label>
        <input type="text" name="TITLE">
        <label>Author name: </label>
        <input type="text" name="AUTHOR_NAME">
        <label>Post content: </label>
        <textarea name="CONTENT" rows="20" cols="35"></textarea>
        <label></label>
        <input type="submit" name="Submit">
    </fieldset>
</form>

</body>
</html>
