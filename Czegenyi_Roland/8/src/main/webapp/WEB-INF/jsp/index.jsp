<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
   <head>
       <title>Simple Blog</title>
       <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
   </head>
<body>

<p class="title">Simple Blog</p>

<div class="post">
    <c:forEach var="post" items="${posts}">
        <div class="new">
            <a href="/blog?id=${post.id}">
                <div id="title">${post.title}</div>
            </a>
            <div id="inline">
                <span><fmt:formatDate value="${post.date}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                <span>${post.author}</span>
            </div>
        </div>
    </c:forEach>
</div>

<div class="new">
    <a href="blog/addpost">Add a new post.</a>
</div>
</body>
</html>
