<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${blog.title}</title>
</head>
<body>
<p>${blog.author}</p>
<p>${blog.title}</p>

<c:forEach var="comment" items="${blog.comments}">
    <p>${comment.content}</p>
</c:forEach>

<form action="/comment-servlet" method="post" id="commentForm">
    <input type="hidden" value="${blog.id}" name="id"/>
    <textarea name="CONTENT" rows="5" cols="20"></textarea></br>
    <input type="submit" name="Submit">
</form>
</body>
</html>
