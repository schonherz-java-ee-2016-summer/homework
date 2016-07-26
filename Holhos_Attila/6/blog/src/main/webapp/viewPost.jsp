<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Post</title>
    <link rel="stylesheet"  href="/blog/singlePost.css">
    <script type="text/javascript" src="/blog/javascript.js"></script>
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
            <c:if test="${empty post.comments}">
                <div id="nocomment">There are no comments yet.</div>
            </c:if>
            <c:forEach items="${post.comments}" var="comment">
                <div class="comment">
                    <p>${comment.content}</p>
                    <p id="commentdate">${comment.commentDate}</p>
                </div>
            </c:forEach>
        </div>
        <form method="post" action="/blog/commentServlet?ID=${post.postID}" onsubmit="return validateComment()">
            <div id="addComment">
                <div>
                    <label for="newcomment">Add comment:</label>
                    <input id="newcomment" name="newcomment" type='text'>
                </div>
                <button type="submit">Send</button>
            </div>
        </form>
    </body>
</html>
