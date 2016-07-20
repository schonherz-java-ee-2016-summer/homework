<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Sixth Homework New Post</title>
        <link rel="stylesheet" href="blogstyle.css">
    </head>
    <body>
        <form method="post" action="/blog/newpost">
            <label for="name">Name:</label>
            <input id="name" type="text">

            <label for="title">Title:</label>
            <input id="title" type="text">

            <label for="Content">Content:</label>
            <input id="content" type="text" rows="5">

            <button type="submit">Submit</button>
        </form>
    </body>
</html>
