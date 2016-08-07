<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Welcome to this Blog!!!</title>

        <link href="${contextPath}/css/style.css" rel="stylesheet">


    </head>
    <body>
        <c:choose>
            <c:when test="${empty posts}">
                <div class="middle">There ar NO Posts on the blog!!!</div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${posts}" var="post">
                    <div class="post">
                        <div class="number">Post Id : ${post.id}</div>
                        <div class="normal">Post Author: ${post.author}</div>
                        <div class="normal">Post Title: ${post.title}</div>
                        <div class="content">Post Content: ${post.content}</div>
                        <a href="${contextPath}/post/${post.id}">${post.title}</a>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <a class="button" href="${contextPath}/post/new">Create a NEW post!!!</a>
    </body>
</html>
