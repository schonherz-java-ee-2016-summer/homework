<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>new</title>
</head>
<body>
<b>Welcome ${sessionScope.get("userName")}! </b>
<form class="form" method="POST" action="2">
    <div class="leave-a-blog">
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
