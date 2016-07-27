<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Show post - Simple Blog Webapp</title>
        <link rel="stylesheet" type="text/css" href="/css/styleSheet.css"/>
    </head>
    <body>
        <div class="post">
            <p><span class="postCaptions">Title: </span>${post.title}</p>
            <c:set var="cleanedDateTime" value="${fn:replace(post.dateTime, 'T', ' ')}"/>
            <fmt:parseDate value="${cleanedDateTime}" pattern="yyyy-MM-dd HH:mm" var="parsedDateTime" type="both"/>
            <p><span class="postCaptions">Posted at: </span><fmt:formatDate pattern="yyyy.MM.dd. HH:mm"
                                                                            value="${parsedDateTime}"/></p>
            <p><span class="postCaptions">Author: </span>${post.author}</p>
            <p>${post.content}</p>
        </div>
        <a href="/index">
            <button class="button">Back to index</button>
        </a>

        <c:forEach var="comment" items="${post.comments}">
            <div class="comment">
                <p><span class="commentCaptions">Commenter: </span>${comment.commenter}</p>
                <p>${comment.content}</p>
            </div>
        </c:forEach>

        <%--<form method="post" action="/comment-servlet">
            <hr>
            <p>Add comment to this post</p>
            <input name="commenter" type="text" placeholder="Your name..."><br>
            <textarea name="comment" rows="5" cols="30" placeholder="Enter your comment here..."></textarea><br>
            <input class="button" id="addComment" type="submit" name="addComment" value="Add comment">
        </form>--%>
        <div>
            <form:form modelAttribute="comments" method="post" action="/comment/add">
                <hr>
                <p>Add comment to this post</p>
                <div><form:input path="commenter"/></div>
                <div><form:textarea path="comment"/></div>
                <input class="button" id="addComment" type="submit" name="addComment" value="Add comment">
            </form:form>
        </div>
    </body>
</html>
