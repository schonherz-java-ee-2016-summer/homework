<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>fakebook.com</title>
</head>
<body>
<header id="app-header">
    <div><h1> Welcome! </h1></div>
    <div class="app-href"><a href="/index">homepage</a> <a href="/">logout</a></div>
</header>
<form class="form" method="GET" action="/post/new">
    <div>
        <button type="submit">Make a blog!</button>
    </div>
</form>
<c:forEach items="${blogs}" var="item">
    <div><a href="/post/${item.id}">
        <div class="blogpost">
                <div name="author">${item.author}</div>
                <div name="title"> ${item.title}</div>
                <div name="content"> ${item.content}</div>
                <input type="hidden" name="blog_id" value="${item.id}" />
                <div class="line">________________________________________</div>
        </div>
    </a></div>
</c:forEach>
</body>
</html>
