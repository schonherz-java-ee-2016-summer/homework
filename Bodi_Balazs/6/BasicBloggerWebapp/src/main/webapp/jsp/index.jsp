<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>fakebook.com</title>
</head>
<body>
<header id="app-header" class="flex-center centered"> <center> <h1> Welcome on fakebook! </h1> </center>
</header>
<form class="form" method="POST" action="index">
    <div class="leave-a-post" class="login-form">
        <center>
            <label form = "name">Nickname: </label>
            <input name = "name" type = "text">
            <button type="submit">Make a blog!</button>
        </center>
    </div>
</form>
<c:forEach items="${blogList}" var="item">
    <form id="${item.id}" class="form" method="POST" action="post/${item.id}">
        <div>
                ${item.author}
                ${item.title}
                ${item.content}
                <button type="submit">Comment</button>
        </div>
     </form>
</c:forEach>

</body>
</html>
