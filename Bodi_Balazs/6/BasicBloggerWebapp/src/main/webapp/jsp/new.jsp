<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>new</title>
</head>
<body>
<header id="app-header" class="flex-center centered"> <h1> Welcome ${userName}! </h1>
</header>
<form class="form" method="POST" action="/post/new">
    <div>
            <label form = "title">Give us your blog title: </label>
    </div>
    <div>
            <input name = "title" type = "text">
    </div>
    <div>
        <label form = "content">Make your blog above:</label>
    </div>
    <div>
            <input name = "content" type = "text">
            <button type="submit">Leave it!</button>

    </div>
</form>



<form class="form" method ="GET" action="post" typeof="form-set-data">

</form>
</body>
</html>
