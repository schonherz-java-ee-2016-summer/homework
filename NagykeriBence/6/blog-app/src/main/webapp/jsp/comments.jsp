<%--
  Created by IntelliJ IDEA.
  User: Nutty
  Date: 2016.07.21.
  Time: 13:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<html>
<head>
    <title>Welcome ${sessionScope.get(Constants.COMMENTER_INPUT_NAME)}</title>
</head>
<body>
<h1>Welcome ${sessionScope.get(Constants.COMMENTER_INPUT_NAME)}</h1>
<c:if test="${empty sessionScope.get(Constants.COMMENTLIST)}">
    <span>There are no comments yet.</span>
</c:if>

<c:forEach items="${sessionScope.get(Constants.COMMENTLIST)}" var="item">
    <span>${item}</span>
</c:forEach>

</body>
</html>
