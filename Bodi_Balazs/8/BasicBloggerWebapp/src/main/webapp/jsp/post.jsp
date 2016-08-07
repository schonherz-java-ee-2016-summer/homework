<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<head>
    <title>post</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header class="header">
    <div><a href="/index">homepage</a> <a href="/">logout</a></div>
    <div><h1> Welcome! </h1></div>
</header>
<div class="center">
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
        <input name = "content" class = "content" type = "text">
        <input name="blogId" type = "hidden" value="${blog.id}" />
    </div>
    <div>
        <button class="button" type="submit">Leave it!</button>
    </div>
</form>
<b>Comments are above</b>
<c:forEach items="${comments}" var="item">
        <div  class="center-div">
            <div class="center">${item.id} - ${item.author}</div>
            <div class="center"> ${item.content}</div>
        </div>
</c:forEach>
</body>
</html>
