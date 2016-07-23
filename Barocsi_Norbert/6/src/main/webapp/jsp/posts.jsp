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
    </head>
    <body>
        <form class="form" method="post" action="/index">
            <div>Identity: ${poster.identity}</div>
            <div>Author: ${poster.author}</div>
            <div>Time: ${poster.date}</div>
            <div>Title: ${poster.title}</div>
            <div>Content: ${poster.content}</div>

            <div>
                <button type="submit">Index!</button>
            </div>
        </form>
    </body>
</html>
