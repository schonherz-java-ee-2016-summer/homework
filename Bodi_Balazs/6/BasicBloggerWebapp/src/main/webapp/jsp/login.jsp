<%--
  Created by IntelliJ IDEA.
  User: bmbal
  Date: 2016. 07. 23.
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<header id="app-header" class="flex-center centered"> <center> <h1> Welcome on fakebook! </h1> </center>
</header>
<form class="form" method="POST" action="login">
    <div class="leave-a-post" class="login-form">
        <center>
            <label form = "name">Nickname: </label>
            <input name = "name" type = "text">
            <button type="submit">Login</button>
        </center>
    </div>
</form>
</body>
</html>
