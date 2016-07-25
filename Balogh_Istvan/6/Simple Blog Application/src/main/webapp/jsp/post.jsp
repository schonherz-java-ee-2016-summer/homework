<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Show post - Simple Blog Webapp</title>
        <link rel="stylesheet" type="text/css" href="/css/styleSheet.css"/>
    </head>
    <body>
        <div class="post">
            <p><span class="postCaptions">Title: </span>${applicationScope.get("selectedPost").title}</p>
            <c:set var="cleanedDateTime" value="${fn:replace(selectedPost.dateTime, 'T', ' ')}"/>
            <fmt:parseDate value="${ cleanedDateTime }" pattern="yyyy-MM-dd HH:mm" var="parsedDateTime" type="both"/>
            <p><span class="postCaptions">Posted at: </span><fmt:formatDate pattern="yyyy.MM.dd. HH:mm"
                                                                            value="${parsedDateTime}"/></p>
            <p><span class="postCaptions">Author: </span>${applicationScope.get("selectedPost").author}</p>
            <p>${applicationScope.get("selectedPost").content}</p>
        </div>
        <a href="/index">
            <button class="button">Back to index</button>
        </a>

        <c:forEach var="comment" items="${selectedPost.comments}">
            <div class="comment">
                <p><span class="commentCaptions">Commenter: </span>${comment.commenter}</p>
                <p>${comment.content}</p>
            </div>
        </c:forEach>

        <form method="post" action="/comment-servlet">
            <hr>
            <p>Add comment to this post</p>
            <input name="commenter" type="text" placeholder="Your name..."><br>
            <textarea name="comment" rows="5" cols="30" placeholder="Enter your comment here..."></textarea><br>
            <input class="button" id="addComment" type="submit" name="addComment" value="Add comment">
        </form>
    </body>
</html>
