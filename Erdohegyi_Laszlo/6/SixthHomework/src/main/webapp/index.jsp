<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework Index</title>
        <link rel="stylesheet" href="blogstyle.css">
    </head>
    <body>
        <h2>Welcome</h2>
        <p/>

        <c:forEach items="${postList}" var="post">
            <div class="blogpost">
                <p>${post.title}</p>
                <p>${post.author}</p>
                <p>${post.postDate}</p>
            </div>
        </c:forEach>
    </body>
</html>
