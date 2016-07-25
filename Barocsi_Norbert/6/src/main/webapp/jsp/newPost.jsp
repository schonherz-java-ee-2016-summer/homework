<%--
  Created by IntelliJ IDEA.
  User: Mindfield
  Date: 2016. 07. 21.
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>New Post</title>
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/forms.css">
    </head>
    <body>
        <form class="form" method="post" action="/newPost">

            <div class="form-element">
                <label for="author">Author: </label>
                <input id="author" name="author" type="text"/>
            </div>
            <div class="form-element">
                <label for="title">Title: </label>
                <input id="title" name="title" type="text"/>
            </div>
            <div class="form-element">
                <label for="content">Content: </label>
                <textarea id="content" name="content"></textarea>
            </div>
            <div class="form-element">
                <button class="btn" type="submit">Post!</button>
            </div>
        </form>
    </body>
</html>
