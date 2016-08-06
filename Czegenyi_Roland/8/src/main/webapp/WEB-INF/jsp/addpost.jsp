<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
       <title>Add a new post.</title>
       <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
   </head>
<body>

<p class="title">Simple Blog</p>

<form:form action="/blog/addpost" method="post" id="blogForm">

    <fieldset class="new">
        <label>Title: </label>
        <form:input path="author"/>
        <label>Author name: </label>
        <form:input type="text" path="title"/>
        <label>Post content: </label>
        <form:textarea path="content" rows="20" cols="35"></form:textarea>
        <label></label>
        <input type="submit" name="Submit">
    </fieldset>

</form:form>
</body>
</html>
