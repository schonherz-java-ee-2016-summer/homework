<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
            <title>Blog post ${pageContext.request.requestURL.substring(pageContext.request.requestURL.length()-1)}</title>
    </head>
    <body>

        <h1>Add a comment to post ${post.title}!</h1>
        <div>Post ID: ${post.id}</div>
        <div>Post Author: ${post.author}</div>
        <div>Post Time: ${post.date}</div>
        <div>Post Title: ${post.title}</div>
        <div>Content: ${post.content}</div>
            <c:forEach items="${post.comments}" var="comment">
                <div>Comment ID: ${comment.id}</div>
                <div>Comment Date: ${comment.date}</div>
                <div>Comment Content: ${comment.content}</div>
            </c:forEach>
        <input type="hidden" name="id" value="${post.id}"/>

        <form method="post" action="/addcomment?id=${post.id}">

                    <div>
                        <span>Add a new Comment!</span>
                    </div>
                    <div>
                        <label for="new-post-content">Comment Content:</label>
                        <input id="new-post-content" name="content" type="text">
                    </div>

                    <div>
                        <button type="submit">Add Comment</button>
                    </div>
            </form>
    </body>
</html>
