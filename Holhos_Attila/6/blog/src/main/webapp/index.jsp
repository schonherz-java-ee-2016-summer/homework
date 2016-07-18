<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Blog</title>
        <link rel="stylesheet" href="style.css">

    </head>
    <body>
        <h2 id="welcome">Welcome in this blog!</h2>
        <div id="left">You can read a post, if you click on that. Or if you want to add a new post, click on the add button.</div>
        <div id="right"><a href="newPost.jsp">Add a post</a></div>
        <c:forEach items="${postsList}" var="item">
            <div class="blogposzt">
                <p>${item.author}</p>
                <p>${item.postDate}</p>
                <p>${item.title}</p>
                <p>${item.content}</p>
            </div>
        </c:forEach>
    </body>
</html>
