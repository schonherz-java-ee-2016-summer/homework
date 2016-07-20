<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework Show Post</title>
        <link rel="stylesheet" href="blogstyle.css">
    </head>
    <body>
        <div>
            <p id="title">title</p>
            <p id="author">author</p>
            <p id="content">content</p>
            <p id="date">date</p>
            <c:forEach items="${comments}" var="com">
                <div class="comment">
                    <p>${com.title}</p>
                    <p>${com.author}</p>
                    <p>${com.postDate}</p>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
