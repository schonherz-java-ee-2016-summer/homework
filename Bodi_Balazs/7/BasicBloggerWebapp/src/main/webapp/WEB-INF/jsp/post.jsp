<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>post</title>
</head>
<body>
<header id="app-header">
    <div class="app-href"><a href="/index">homepage</a> <a href="/">logout</a></div>
    <div><h1> Welcome! </h1></div>
</header>
<div>
    ${blog.author}
    ${blog.title}
    ${blog.content}
</div>
<form method="POST" action="/post/${blog.id}">
    <div>
        <h1>${user.name}</h1>
    </div>
    <div>
        <label>Your comment:</label>
    </div>
    <div>
        <input name = "content" type = "text">
        <input type="hidden" name="blog_id" value="${blog.id}" />
        <button type="submit">Leave it!</button>

    </div>
</form>
<b>Comments are above</b>
<c:forEach items="${comments}" var="item">
        <div  class="app-content-div">
            <div class="author">${item.id} - ${item.author}</div>
            <div class="content"> ${item.content}</div>
            <div class="line">________________________________________</div>
        </div>
</c:forEach>
</body>
</html>
