<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Show post - Simple Blog Webapp</title>
    </head>
    <body>
        <p>${applicationScope.get("selectedPost").title}</p>
        <p>${applicationScope.get("selectedPost").dateTime}</p>
        <p>${applicationScope.get("selectedPost").author}</p>
        <p>${applicationScope.get("selectedPost").content}</p>
        <a href="/index">
            <button>Back to index</button>
        </a>

        <c:forEach var="comment" items="${selectedPost.comments}">
            <hr>
            <p>${comment.commenter}</p>
            <p>${comment.content}</p>
        </c:forEach>

        <form method="post" action="/comment-servlet">
            <hr>
            <p>Add comment to this post</p>
            <input name="commenter" type="text" placeholder="Your name..."><br>
            <textarea name="comment" rows="5" cols="30" placeholder="Enter your comment here..."></textarea><br>
            <input id="addComment" type="submit" name="addComment" value="Add comment">
        </form>
    </body>
</html>
