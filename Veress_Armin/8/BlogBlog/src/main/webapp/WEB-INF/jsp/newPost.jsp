<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2016.08.05.
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Post</title>
    </head>
    <body>
        <form action="/post" method="post">
            Name: <input type="text" name="author" />
            Title: <input type="text" name="title" />
            Post: <textarea name="content" rows="5" cols="30"></textarea>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
