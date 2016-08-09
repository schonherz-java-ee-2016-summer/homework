<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Post ${post.title}</title>

    <link href="${contextPath}/css/style.css" rel="stylesheet">

</head>
<body>
    <div class="post">
    <div>Post Id: ${post.id}</div>
    <div>Post Author: ${post.author}</div>
    <div>Post Title: ${post.title}</div>
    <div>Post Content: ${post.content}</div>
    </div>
    <c:forEach items="${post.comments}" var="comment">
        <div class="comment">
        <div>Comment Id: ${comment.id}</div>
        <div>Comment Content : ${comment.content}</div>
        </div>
    </c:forEach>

    <form:form action="/post/${post.id}" method="POST" modelAttribute="newcomment">
        <div><form:label path="content">Comment Content: </form:label></div>
        <div><form:textarea path="content" rows="5"/></div>
        <div><form:hidden path="blog_id"/></div>
        <input type="submit" value="Add Comment!">
    </form:form>

</body>
</html>
