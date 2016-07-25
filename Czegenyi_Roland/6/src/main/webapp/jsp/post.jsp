<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>${blog.title}</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>
<p class="title"><a href="/index">Simple Blog</a></p>

<div class="new">
    <div id="title"> ${blog.title}</div>

    <div id="inline">
        <span><fmt:formatDate value="${blog.date}" pattern="yyyy-MM-dd HH:mm:ss"/></span> *
        <span>${blog.author}</span>
    </div>
</div>

<div class="new" id="content">${blog.content}</div>

<div align="center">Comments:</div>

<div class="new">
    <c:forEach var="comment" items="${blog.comments}">
        <span><fmt:formatDate value="${comment.date}" pattern="yyyy-MM-dd HH:mm:ss"/></span> *
        <p>${comment.content}</p>
        <hr/>
    </c:forEach>
</div>

<div align="center">
    <form action="/comment-servlet" method="post" id="commentForm">
        <input type="hidden" value="${blog.id}" name="id"/>
        <textarea name="CONTENT" rows="10" cols="30"></textarea></br>
        <input type="submit" name="Submit">
    </form>
</div>

</body>
</html>
