<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>fakebook.com</title>
</head>
<body>
<header id="app-header">
    <div class="app-href"><a href="/index">homepage</a> <a href="/">logout</a></div>
    <div><h1> Welcome ${name}! </h1></div>
</header>
<form class="form" method="GET" action="/post/new">
    <div>
        <button type="submit">Make a blog!</button>
    </div>
</form>
<c:forEach items="${blogList}" var="item">
    <div class="app-content-div"><a href="/post/${item.id}">
        <div class="blogpost">
                <div class="author">${item.author}</div>
                <div class="date">${item.date}</div>
                <div class="title"> ${item.title}</div>
                <div class="content"> ${item.content}</div>
                <input type="hidden" name="blogId" value="${item.id}" />
                <div class="line">________________________________________</div>
        </div>
    </a></div>
</c:forEach>

</body>
</html>
