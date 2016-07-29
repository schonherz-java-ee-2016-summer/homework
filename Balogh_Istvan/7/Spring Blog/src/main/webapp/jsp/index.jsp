<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Index - Simple Blog Webapp</title>
        <link rel="stylesheet" type="text/css" href="/css/styleSheet.css"/>
    </head>
    <body><%--
        <div>
            <form method="post" action="/post/new">
                <input class="button" id="newPost" type="submit" name="newPost" value="Create new post">
            </form>
        </div>--%>

        <div>
            <a href="/post/new/">
                Create new post
            </a>
        </div>

        <c:forEach var="post" items="${posts}">
            <div class="post">
                <p><span class="postCaptions">Title: </span> ${post.title}</p>
                <c:set var="cleanedDateTime" value="${fn:replace(post.dateTime, 'T', ' ')}" />
                <fmt:parseDate value="${cleanedDateTime}" pattern="yyyy-MM-dd HH:mm" var="parsedDateTime" type="both" />
                <p><span class="postCaptions">Posted at: </span><fmt:formatDate pattern="yyyy.MM.dd. HH:mm" value="${parsedDateTime}" /></p>
                <p><span class="postCaptions">Author: </span>${post.author}</p>
                <a href="/post?id=${post.id}">
                    <button class="button">Show this post</button>
                </a>
            </div>
        </c:forEach>
    </body>
</html>
