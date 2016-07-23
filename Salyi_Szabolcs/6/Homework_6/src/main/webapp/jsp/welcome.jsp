<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
        <head>
            <title>Welcome to this simple blog!</title>
        </head>
        <body>
            <div>valami</div>
            <form method="POST" action="/index">
                <div id="new-post-header">
                    <span>Add a new post!</span>
                </div>
                <div>
                    <label for="new-post-name">Author Name:</label>
                    <input id="new-post-name" name="author" type="text">
                </div>
                <div>
                    <label for="new-post-title">Post Title:</label>
                    <input id="new-post-title" name="title" type="text">
                </div>
                <div>
                    <label for="new-post-content">Post Content:</label>
                    <input id="new-post-content" name="title" type="text">
                </div>

                <div>
                    <button type="submit">Add The Post</button>
                </div>
            </form>
        </body>
</html>
