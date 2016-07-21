<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add new post</title>
    <link rel="stylesheet" href="style.css">

</head>
    <body>
    <%@include file="/html/header.html"%>
    <form method="post" action="/blog/addPost">
        <table id="inputTable">
            <tr>
                <td colspan="2"><h2>Add a new post!</h2></td>
            </tr>
            <tr>
                <td><label for="user">Author name:</label></td>
                <td><input id="user" name="user" type="text"></td>
            </tr>
            <tr>
                <td><label for="title">Title:</label></td>
                <td><input id="title" name="title" type="text"></td>
            </tr>
            <tr>
                <td><label for="Content">Content:</label></td>
                <td><input id="content" name="content" type="text" rows="5"></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Add the post</button></td>
            </tr>
        </table>
    </form>
    </body>
</html>
