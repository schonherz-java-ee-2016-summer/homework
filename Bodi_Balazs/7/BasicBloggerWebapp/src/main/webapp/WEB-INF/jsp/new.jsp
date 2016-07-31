<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>new</title>
</head>
<body>
<header id="app-header">
    <div class="app-href"><a href="/index">homepage</a> <a href="/">logout</a></div>
    <div><h1> Welcome ${name}! </h1></div>
</header>
<form method="POST" action="/post/new">
    <div class="newBlog">
        <div>
            <h1>${name}</h1>
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
                <input name = "content" type = "text">
                <button class = "submit" type="submit">Leave it!</button>

        </div>
    </div>

</form>
</body>
</html>
