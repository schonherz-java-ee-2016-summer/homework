<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Seventh Homework Index</title>
        <link rel="stylesheet" type="text/css" href="../../resources/blogstyle.css">
    </head>
    <body>
        <h2>Welcome</h2>

        <div>
            <a href="/newpost">
                <button>New post</button>
            </a>
        </div>

        <c:forEach items="${posts}" var="post">
            <div class="blogpost">
                <p>${post.title}</p>
                <p>${post.author}</p>
                <p>${post.date}</p>
                <a href="/showpost?id=${post.id}">
                    <button>Show post</button>
                </a>
            </div>
        </c:forEach>
    </body>
</html>
