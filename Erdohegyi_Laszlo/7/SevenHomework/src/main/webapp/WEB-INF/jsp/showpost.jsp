<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework Show Post</title>
        <link rel="stylesheet" type="text/css" href="../../resources/blogstyle.css">
    </head>
    <body>
        <div>
            <p id="title">${post.title}</p>
            <p id="author">${post.author}</p>
            <p id="content">${post.content}</p>
            <p id="date">${post.date}</p>
            <c:forEach items="${post.comments}" var="comment">
                <div class="comment">
                    <p>${comment.content}</p>
                    <p>${comment.date}</p>
                </div>
            </c:forEach>
            <form method="post" action="/showpost">
                <p>Add a comment to this post:</p>
                <input name="comcontent" type="text">
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
