<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Show post - Simple Blog Webapp</title>
    </head>
    <body>
        <p>${sessionScope.get("selectedPost").dateTime}</p>
        <p>${sessionScope.get("selectedPost").author}</p>
        <p>${sessionScope.get("selectedPost").content}</p>
    </body>
</html>
