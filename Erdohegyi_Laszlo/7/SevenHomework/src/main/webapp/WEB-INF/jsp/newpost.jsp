<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework New Post</title>
        <link rel="stylesheet" type="text/css" href="../../resources/blogstyle.css">
    </head>
    <body>
        <form method="post" action="/newpost">
            <label for="author">Name:</label>
            <input id="author" name="author" type="text">

            <label for="title">Title:</label>
            <input id="title" name="title" type="text">

            <label for="content">Content:</label>
            <input id="content" name="content" type="text">

            <button type="submit">Submit</button>
        </form>
    </body>
</html>
