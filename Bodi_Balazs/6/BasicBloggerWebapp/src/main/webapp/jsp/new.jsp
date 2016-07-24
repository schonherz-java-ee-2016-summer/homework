<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>new</title>
</head>
<body>
<header id="app-header" class="flex-center centered">
<form method="get" action="index">
    <button class="homepageButton" type="submit"><h1>Homepage</h1></button>
</form>
</header>
<form method="POST" action="/post/new">
    <div class="newBlog">
        <div>
            <label form = "name">Nickname: </label>
        </div>
        <div>
            <input name = "userName" type = "text">
        </div>
        <div>
                <label form = "title">Give us your blog title: </label>
        </div>
        <div>
                <input name = "title" type = "text">
        </div>
        <div>
            <label form = "content">Make your blog above:</label>
        </div>
        <div>
                <input type="hidden" name="id" value="${blogId}"/>
                <input name = "content" type = "text">
                <button class = "submit" type="submit">Leave it!</button>

        </div>
    </div>

</form>
</body>
</html>
