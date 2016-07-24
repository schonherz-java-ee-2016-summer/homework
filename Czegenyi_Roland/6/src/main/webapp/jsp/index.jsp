<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Blog</title>
</head>
<body>

<c:forEach var="post" items="${posts}">

    <p>${post.author}</p>
    <p>${post.title}</p>
    <p>${post.content}</p>
    <p>${post.id}</p>

    <p><a href="/post-servlet?id=${post.id}">alldata</a></p>
</c:forEach>

<div>
    <a href="addpost/new">new blog</a>
</div>
</body>
</html>
