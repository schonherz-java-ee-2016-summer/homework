<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework Show Post</title>
        <link rel="stylesheet" type="text/css" href="blogstyle.css">
    </head>
    <body>
        <div>
            <p id="title">${applicationScope.get("actual_post").title}</p>
            <p id="author">${applicationScope.get("actual_post").author}</p>
            <p id="content">${applicationScope.get("actual_post").content}</p>
            <p id="date">${applicationScope.get("actual_post").date}</p>
            <%--<c:forEach items="${comments}" var="com">
                <div class="comment">
                    <p>${com.title}</p>
                    <p>${com.author}</p>
                    <p>${com.postDate}</p>
                </div>
            </c:forEach>--%>
        </div>
    </body>
</html>
