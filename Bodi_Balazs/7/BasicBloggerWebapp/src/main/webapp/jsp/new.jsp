<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<head>
    <title>new</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<header>
    <div><a href="/index">homepage</a> <a href="/">logout</a></div>
    <div><h1> Welcome! </h1></div>
</header>
<form method="POST" action="/post/new">
    <div>
        <div>
            <h1>${author}</h1>
        </div>
        <div>
                <label>Give us your blog title: </label>
        </div>
        <div>
                <input name = "title" class = "title" type = "text">
        </div>
        <div>
            <label>Make your blog above:</label>
        </div>
        <div>
                <input name = "content" class="content" type = "text">
                <button class = "submit" type="submit">Leave it!</button>

        </div>
    </div>

</form>
</body>
</html>
