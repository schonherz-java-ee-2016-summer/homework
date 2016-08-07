<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Show post - Spring Blog Webapp</title>
        <link rel="stylesheet" type="text/css" href="/resources/css/styleSheet.css"/>
    </head>

    <body>

        <h1>Spring Blog Webapp</h1>

        <div class="post">
            <p><span class="postCaptions">Title: </span>${post.title}</p>
            <c:set var="cleanedDateTime" value="${fn:replace(post.dateTime, 'T', ' ')}"/>
            <fmt:parseDate value="${cleanedDateTime}" pattern="yyyy-MM-dd HH:mm" var="parsedDateTime" type="both"/>
            <p><span class="postCaptions">Posted at:
                </span><fmt:formatDate pattern="yyyy.MM.dd. HH:mm" value="${parsedDateTime}"/></p>
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

        <div>
            <form:form modelAttribute="newcomment" method="post" action="/comment/add?id=${post.id}">
                <hr>
                <p>Add comment to this post</p>
                <div><form:input path="commenter"/></div>
                <div><form:textarea cols="" path="content"/></div>
                <input class="button" id="addComment" type="submit" name="addComment" value="Add comment">
            </form:form>
        </div>

    </body>
</html>
