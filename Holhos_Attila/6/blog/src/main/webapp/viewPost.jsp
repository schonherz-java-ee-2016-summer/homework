<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Post</title>
    <link rel="stylesheet" href="aPost.css">
    <script type="text/javascript" src="javascript.js"></script>
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
            <c:forEach items="${comments}" var="comment">
                <div class="comment">
                    <p>${comment.content}</p>
                    <p id="commentdate">${comment.commentDate}</p>
                </div>
            </c:forEach>
        </div>
        <form method="post" action="/blog/addComment?ID=${post.postID}">
            <div id="addComment">
                Share your opinion and add new comment!
                <div>
                    <label for='newcomment'>Add comment:</label>
                    <input id='newcomment' name='newcomment' type='text'>
                </div>
                <button type='submit'>Send</button>
            </div>
        </form>
    </body>
</html>
