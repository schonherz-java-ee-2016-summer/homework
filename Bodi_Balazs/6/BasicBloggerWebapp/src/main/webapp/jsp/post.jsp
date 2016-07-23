<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>post</title>
</head>
<body>
<header id="app-header" class="flex-center centered"> <h1> Welcome ${userName}! </h1>
</header>
<div>
    ${requiredBlog.author}
    ${requiredBlog.title}
    ${requiredBlog.content}
</div>
<form class="form" method="POST" action="/post/">
    <div>
        <label>Your comment:</label>
    </div>
    <div>
        <input id = "${requiredBlog.id}" name = "content" type = "text">
        <button type="submit">Leave it!</button>

    </div>
</form>
<b>Comments are above</b>
<c:forEach items="${requiredComments}" var="item">
        <div>
                ${item.author}
                ${item.content}
        </div>
</c:forEach>
</body>
</html>
