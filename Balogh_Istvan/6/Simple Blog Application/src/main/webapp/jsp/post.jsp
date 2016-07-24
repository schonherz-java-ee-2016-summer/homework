<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Show post - Simple Blog Webapp</title>
    </head>
    <body>
        <p>${applicationScope.get("selectedPost").title}</p>
        <p>${applicationScope.get("selectedPost").dateTime}</p>
        <p>${applicationScope.get("selectedPost").author}</p>
        <p>${applicationScope.get("selectedPost").content}</p>
        <a href="/index">
            <button>Back to index</button>
        </a>
    </body>
</html>
