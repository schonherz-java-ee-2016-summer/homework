<%--
  Created by IntelliJ IDEA.
  User: Mindfield
  Date: 2016. 07. 21.
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Index</title>
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/forms.css">
    </head>
    <body>

        <form class="form" method="get" action="/post/new">
            <div class="form-element">
                <button class="btn" type="submit">New Post!</button>
            </div>
        </form>
        <c:forEach items="${blogList}" var="element">

            <div class="form">
                <span class="form-element">${element.identity}</span>
                <span class="form-element">${element.author}</span>
                <span class="form-element">${element.date}</span>
                
                <a class="form-element" href="/post/${element.identity}">
                    <button class="btn">Show Post!</button>
                </a>
            </div>

        </c:forEach>
    </body>
</html>
