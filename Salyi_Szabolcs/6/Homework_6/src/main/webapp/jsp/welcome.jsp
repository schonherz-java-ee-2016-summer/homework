<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
        <head>
            <title>Welcome to this simple blog!</title>
            <link  rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">
        </head>
        <body>
            <c:forEach items="${posts}" var="post">
                <div>
                    <span>Post ID: ${post.getId()}</span><br>
                    <span>Post Title: ${post.getTitle()}</span><br>
                    <span>Post Author: ${post.getAuthor()}</span><br>
                    <span>Post Date: ${post.getDate()}</span>
                    <a href="/post/${post.getId()}">
                        <button>Show Post</button>
                    </a>
                </div>
            </c:forEach>
            <form method="POST" action="/index">
                <div id="footer">
                    <div id="new-post-header">
                        <span>Add a new post!</span>
                    </div>
                    <div>
                        <label for="new-post-name">Author Name:</label>
                        <input id="new-post-name" name="author" type="text">
                    </div>
                    <div>
                        <label for="new-post-title">Post Title:</label>
                        <input id="new-post-title" name="title" type="text">
                    </div>
                    <div>
                        <label for="new-post-content">Post Content:</label>
                        <input id="new-post-content" name="content" type="text">
                    </div>

                    <div>
                        <button type="submit">Add The Post</button>
                    </div>
                </div>
            </form>
        </body>
</html>
