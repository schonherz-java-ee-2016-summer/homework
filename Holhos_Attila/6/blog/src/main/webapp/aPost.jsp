<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Post</title>
    <link rel="stylesheet" href="style.css">

</head>
    <body>
    <div id="aPost"></div>
        <h2 id="title">${post.title}</h2>
        <h3 id="author">${post.author}</h3>
        <p id="context">${post.content}</p>
        <span id="date">${post.postDate}</span>
    </body>
</html>
