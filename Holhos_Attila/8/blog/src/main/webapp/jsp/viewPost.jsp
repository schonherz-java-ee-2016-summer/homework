<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Post</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/singlePost.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/javascript.js"></script>
</head>
    <body>
    <%@include file="/html/header.html"%>
        <div id="aPost">
            <h2 id="postTitle">${post.title}</h2>
            <h3 id="postAuthor">Author is ${post.author}</h3>
            <p id="postContext">${post.content}</p>
            <div id="postDate">${post.postDate}</div>
        </div>

        <div id="comments">
            Comments about this post:
            <c:choose>
                <c:when test="${empty post.comments}">
                    <div id="nocomment">There are no comments yet.</div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${post.comments}" var="comment">
                        <div class="comment">
                            <p>${comment.content}</p>
                            <p id="commentdate">${comment.commentDate}</p>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>

        <form:form modelAttribute="comment" method="post" action="/blog/comment/new" onsubmit="return validateComment()">
            <div id="addComment">
                <div>
                    <label for="content">Add comment:</label>
                    <form:input path="content"/>
                </div>
                <div><form:hidden path="postID"/></div>
                <button type="submit">Send</button>
            </div>
        </form:form>

    </body>
</html>
