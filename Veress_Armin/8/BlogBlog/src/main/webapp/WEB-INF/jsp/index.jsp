<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog</title>
    </head>
    <body>
        <a href="/post/add">Add Post</a>
        <c:forEach items="${posts}" var="post">
            <a href="/post/${post.id}" ><h3>${post.title} <span>${post.author}</span> ${post.date}</h3></a>
        </c:forEach>
    </body>
</html>
