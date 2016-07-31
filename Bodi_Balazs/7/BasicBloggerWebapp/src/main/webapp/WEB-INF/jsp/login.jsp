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
</head>
<body>
<form class="form" method="POST" action="/login">
    <div>
        <label form = "name">Nickname: </label>
    </div>
    <div>
        <input name = "name" type = "text">
        <button type="submit">login</button>
    </div>
</form>
</body>
</html>
