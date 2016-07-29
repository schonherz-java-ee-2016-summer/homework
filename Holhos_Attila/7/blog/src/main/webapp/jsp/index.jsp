<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Blog</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <%@include file="/html/header.html"%>
        <h2 id="welcome">Welcome on this blog!</h2>
        <div id="addPost"><a href="/post/new">Add a post</a></div>
        <div id="posts">
            <c:forEach items="${postsList}" var="item">
                <div id="${item.postID}" class="blogposzt">
                    <div class="author">Author: ${item.author}</div>
                    <div class="date">${item.postDate}</div>
                    <div class="title">${item.title}</div>
                    <div class="postid"><a href="/post/${item.postID}">#${item.postID}</a></div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
