<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Add new blogpost - Spring Blog Webapp - </title>
        <link rel="stylesheet" type="text/css" href="/resources/css/styleSheet.css"/>
    </head>

    <body>

        <h1>Spring Blog Webapp</h1>

        <div>
            <form:form modelAttribute="post" method="post" action="/post/create">
                <div><form:input path="author" placeholder="Your name..."/></div>
                <div><form:input path="title" placeholder="Title of your post..."/></div>
                <div><form:textarea path="content" placeholder="Enter your blogpost here..." rows="10" cols="50"/></div>
                <button class="button" name="submitNewPost" type="submit">Submit post</button>
            </form:form>
        </div>

    </body>
</html>
