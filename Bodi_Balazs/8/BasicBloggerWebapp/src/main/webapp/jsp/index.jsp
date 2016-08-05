<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<head>
    <title>fakebook.com</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body >
<header>
    <div class="app-href"><a href="/index">homepage</a> <a href="/">logout</a></div>
    <div><h1> Welcome ${sessionScope.get("user.name")}! </h1></div>
</header>
<form class="form" method="GET" action="/post/new">
    <div>
        <button type="submit">Make a blog!</button>
    </div>
</form>
<c:forEach items="${blogs}" var="item">
    <div  class="center-div"><a href="/post/${item.id}">
                <div name="author" class="center">${item.author}</div>
                <div name="title" class="center"> ${item.title}</div>
                <div name="content" class="center"> ${item.content}</div>
                <input type="hidden" name="blog_id" value="${item.id}" />
    </a></div>
</c:forEach>
</body>
</html>
