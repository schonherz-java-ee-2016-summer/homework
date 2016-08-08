<%--
  Created by IntelliJ IDEA.
  User: Mindfield
  Date: 2016. 07. 21.
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>New Post</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/resources/css/button.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/forms.css">
    </head>
    <body>
        <form:form class="form" method="POST" action="create">

            <div class="form-element">
                <label>Creator: </label>
                <form:input path="creator"/>
            </div>
            <div class="form-element">
                <label>Title: </label>
                <form:input path="title"/>
            </div>
            <div class="form-element">
                <label>Text: </label>
                <form:textarea path="text" rows="5"/>
            </div>
            <div class="form-element">
                <button class="btn" type="submit">Post!</button>
            </div>
        </form:form>
    </body>
</html>
