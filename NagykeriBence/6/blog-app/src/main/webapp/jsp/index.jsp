<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome ${applicationScope.get(Constants.POSTER_INPUT_NAME)}</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<c:if test="${empty applicationScope.get(Constants.POSTLIST)}">
    <span>There are no posts yet.</span>
</c:if>

<c:forEach items="${applicationScope.get(Constants.POSTLIST)}" var="item">
    <div class="commentBox">
        <span>${item.getPostID()}</span>
        <br/>
        <span>${item.getAuthor().getFirstName()}</span>
        <br/>
        <span>${item.getMessage()}</span>
    </div>
</c:forEach>
<form action='${Constants.POST_SESSION_KEY}' method='POST'>
    <div>
        <input name='${Constants.COMMENTER_INPUT_NAME}'
               value='${applicationScope.get(Constants.POSTER_INPUT_NAME)}'></input>
    </div>
    <div>
        <textarea name='${Constants.NEW_POST_INPUT_NAME}' placeholder='Enter message here.'></textarea>
    </div>
    <div>
        <input type='submit' value='Submit'></input>
    </div>
</form>

</body>
</html>
