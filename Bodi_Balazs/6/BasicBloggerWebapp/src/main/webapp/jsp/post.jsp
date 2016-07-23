<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<head>
    <title>post</title>
</head>
<body>
<b>Welcome ${sessionScope.get("userName")}! </b>
<b>Comments are above</b>
<form class="form" method="GET">

</form>
</body>
</html>
