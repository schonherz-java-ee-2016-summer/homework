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
        <title>${applicationScope.get(Constants.SELECTED_POST).getAuthor().getNickName()}, ${applicationScope.get(Constants.SELECTED_POST).getTitle()}
            - Fullos Blog Post.</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="back">
            <div>
                <a href="${pageContext.request.contextPath}/"><img
                        src="${pageContext.request.contextPath}/images/fullosblog.png" alt="Fullos Blog"
                        title="Fullos Blog"></a>
            </div>
            <div class="box">
                <div class="postHeader">
                    <span>${applicationScope.get(Constants.SELECTED_POST).getPostID()}</span>
                    <span>${applicationScope.get(Constants.SELECTED_POST).getAuthor().getNickName()}</span>
                    <span>${applicationScope.get(Constants.SELECTED_POST).getTitle()}</span>
                </div>
                <div class="postContent">
                    <span>${item.getMessage()}</span>
                </div>
            </div>
            <c:if test="${empty applicationScope.get(Constants.SELECTED_POST).getComments().getComments()}">
                <span>There are no comments yet.</span>
            </c:if>
            <c:forEach items="${applicationScope.get(Constants.SELECTED_POST).getComments().getComments()}"
                       var="item">
                <div class="box">
                    <div class="postHeader">
                        <span>#${item.getCommentID()}</span>
                        <span>${item.getCommenter()}</span>
                    </div>
                    <div class="postContent">
                        <span>${item.getContent()}</span>
                    </div>
                </div>
            </c:forEach>
            </form>
            <div>
                <a href="${pageContext.request.contextPath}/newcomment">New comment</a>
            </div>
        </div>

    </body>
</html>
