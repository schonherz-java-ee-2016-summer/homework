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
    </head>
    <body>
        <form class="form" method="post" action="/post/*">
            <div class="form-element">
                <button class="btn" type="submit">New Post!</button>
            </div>

            <c:forEach items="postList" var="element">
                <div>${element.author}</div>
            </c:forEach>
        </form>

    </body>
</html>
