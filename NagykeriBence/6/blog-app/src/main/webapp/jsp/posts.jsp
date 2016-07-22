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
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome ${applicationScope.get(Constants.COMMENTER_INPUT_NAME)}</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body>
        <h1>IT WORKS!</h1>
        <a href="${pageContext.request.contextPath}/newcomment">New comment</a>
        <!--
        <div class="back">
            <h1>Welcome ${applicationScope.get(Constants.COMMENTER_INPUT_NAME)}</h1>
            <c:if test="${empty applicationScope.get(Constants.COMMENTLIST)}">
                <span>There are no comments yet.</span>
            </c:if>

            <c:forEach items="${applicationScope.get(Constants.COMMENTLIST)}" var="item">
                <div class="box">
                    <span>${item.getCommenter()}</span>
                    <br/>
                    <span>${item.getContent()}</span>
                </div>
            </c:forEach>
            <form action='${Constants.COMMENTS_SESSION_KEY}' method='POST'>
                <div>
                    <input class="inputText" name='${Constants.COMMENTER_INPUT_NAME}'
                           value='${applicationScope.get(Constants.COMMENTER_INPUT_NAME)}'></input>
                </div>
                <div>
                    <textarea class="inputPost" name='${Constants.NEW_COMMENT_INPUT_NAME}'
                              placeholder='Enter comment here.'></textarea>
                </div>
                <div>
                    <input class="button" type='submit' value='Submit'></input>
                </div>
            </form>
        </div>
        -->
    </body>
</html>
