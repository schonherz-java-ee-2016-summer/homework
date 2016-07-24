<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <hr>
                <p>${post.title}</p>
                <p>${post.dateTime}</p>
                <p>${post.author}</p>
                <p>${post.content}</p>
                <a href="/showPost?id=${post.id}">
                    <button>Show this post</button>
                </a>
            </div>
        </c:forEach>
    </body>
</html>
