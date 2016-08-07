<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
    <head>
        <title>Add a new Post!!!</title>
    </head>
    <body>
        <form:form action="/post/new" method="POST" modelAttribute="post">
            <div class="post">
            <div><form:label path="author">Post Author: </form:label></div>
            <div><form:input path="author"/></div>
            <div><form:label path="title">Post Title :</form:label></div>
            <div><form:input path="title"/></div>
            <div> <form:label path="content">Post Content</form:label></div>
            <div><form:textarea path="content" rows="5"/></div>
            <div><input type="submit" value="Add Post"></div>
            </div>
        </form:form>
    </body>
</html>
