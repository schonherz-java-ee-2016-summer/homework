<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>fakebook.com</title>
</head>
<body>
<header id="app-header" class="flex-center centered"> <h1> Welcome! </h1>
</header>
<form class="form" method="POST" action="index">
    <div class="leave-a-post" class="login-form">
        <center>
            <button type="submit">Make a blog!</button>
        </center>
    </div>
</form>
<c:forEach items="${blogList}" var="item">
    <form name="form" class="form" method="GET" action="post/${item.id}">
        <div class="blogpost">
                <div class="author">${item.author}</div>
                <div class="date">${item.date}</div>
                <div class="title"> ${item.title}</div>
                <div class="content"> ${item.content}</div>
                <input type="hidden" name="id" value="${item.id}" />
                <button class="submit" type="submit">Comment</button>
                <div class="line">________________________________________</div>
        </div>
     </form>
</c:forEach>

</body>
</html>
