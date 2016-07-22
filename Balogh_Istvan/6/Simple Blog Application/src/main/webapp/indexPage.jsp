<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Index - Simple Blog Webapp</title>
    </head>
    <body>
        <form method="post" action="/post/new">
            <input id="newPost" type="submit" name="newPost" value="Create new post">
        </form>
        <c:forEach var="post" items="${posts}">
            <div>
                <p>${post.title}</p>
                <p>${post.author}</p>
                <p>${post.content}</p>
            </div>
        </c:forEach>
    </body>
</html>
