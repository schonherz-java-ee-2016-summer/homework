<%--
  Created by IntelliJ IDEA.
  User: Mindfield
  Date: 2016. 07. 22.
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/forms.css">
    </head>
    <body>
        <form class="form" method="post" action="/posts">

            <c:forEach items="${blogList}" var="element">
                <c:if test="${pageContext.request.requestURL.substring(pageContext.request.requestURL.length() - 1) == element.identity}">
                    <div>Identity: ${element.identity}</div>
                    <div>Author: ${element.author}</div>
                    <div>Time: ${element.date}</div>
                    <div>Title: ${element.title}</div>
                    <div>Content: ${element.content}</div>
                    <c:forEach items="${element.comments}" var="listelement">
                        <div>Comment Identity: ${listelement.identity}</div>
                        <div>Comment Date: ${listelement.date}</div>
                        <div>Comment Content: ${listelement.content}</div>
                    </c:forEach>
                    <input type="hidden" name="identity" value="${element.identity}"/>
                </c:if>
            </c:forEach>

            <div class="form-element">
                <label for="comment">Comment: </label>
                <textarea id="comment" name="comment"></textarea>
            </div>
            <div>
                <button class="btn" type="submit">Comment!</button>
            </div>
        </form>

        <form class="form" method="get" action="/posts">
                <button class="btn" type="submit">Index!</button>
        </form>
    </body>
</html>
