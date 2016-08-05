<%-- 
    Document   : newpost
    Created on : Jul 31, 2016, 5:19:12 PM
    Author     : 101001951
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bla Bla Blog</title>
</head>
    <body>
        <h1 align="center">New Post</h1>
        <form method="post" action="/index">
            Name: <input type="text" name="name"><br><br>
            Title: <input type="text" name="title"><br><br>
            New Post: <textarea name="content" style="width:250px;height:150px;"></textarea><br><br>
            <button type="submit" style="width:100px;height:50px;font-size:15px">Submit</button>
        </form>
    </body>
</html>
