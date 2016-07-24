<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework Index</title>
        <link rel="stylesheet" type="text/css" href="blogstyle.css">
    </head>
    <body>
        <h2>Welcome</h2>

        <div>
            <a href="/newpost">
                <button>New post</button>
            </a>
        </div>

        <c:forEach items="${applicationScope.get('posts')}" var="post">
            <div class="blogpost">
                <p>${post.title}</p>
                <p>${post.author}</p>
                <p>${post.date}</p>
            </div>
        </c:forEach>
    </body>
</html>
