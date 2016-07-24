<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>post</title>
</head>
<body>
<header id="app-header" class="flex-center centered">
<form method="get" action="index">
    <button class="homepageButton" type="submit"><h1>Homepage</h1></button>
</form>
</header>
<div>
    ${requiredBlog.author}
    ${requiredBlog.title}
    ${requiredBlog.content}
</div>
<form class="blogpost" method="POST" action="/post">
    <div>
        <label form = "name">Nickname: </label>
    </div>
    <div>
        <input name = "userName" type = "text">
    </div>
    <div>
        <label>Your comment:</label>
    </div>
    <div>
        <input name = "content" type = "text">
        <input type="hidden" name="id" value="${requiredBlog.id}"/>
        <button type="submit">Leave it!</button>

    </div>
</form>
<b>Comments are above</b>
<c:forEach items="${requiredComments}" var="item">
        <div>
            <div class="author">${item.author}</div>
            <div class="date">${item.date}</div>
            <div class="content"> ${item.content}</div>
        </div>
</c:forEach>
</body>
</html>
