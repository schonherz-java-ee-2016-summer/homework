<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form:form method="post" action="/showpost/${post.id}" modelAttribute="newcomment">
                <label for="comcontent">Add a comment to this post: </label>
                <form:textarea id="comcontent" rows="5" cols="50" path="content"/>
                <input type="submit" value="Submit"/>
            </form:form>
        </div>
    </body>
</html>
