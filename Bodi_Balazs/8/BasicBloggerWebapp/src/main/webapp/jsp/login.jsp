<%--
  Created by IntelliJ IDEA.
  User: bmbal
  Date: 2016. 07. 29.
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<header>
    <form name = "author" method="POST" action="/login">
        <div>
            <label class="label">Nickname: </label>
        </div>
        <div>
            <input name = "author" type = "text">
            <button class="button" type="submit">login</button>
        </div>
    </form>
</header>
<body>

</body>
</html>
