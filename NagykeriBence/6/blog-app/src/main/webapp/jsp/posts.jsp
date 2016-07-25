<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>${applicationScope.get(Constants.SELECTED_POST).author.nickName}, ${applicationScope.get(Constants.SELECTED_POST).title}
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
            <div class="postBox">
                <div class="postHeader">
                    <span class="padded">#${applicationScope.get(Constants.SELECTED_POST).postID}</span>
                    <span class="padded">${applicationScope.get(Constants.SELECTED_POST).author.nickName}</span>
                    <span class="padded">${applicationScope.get(Constants.SELECTED_POST).title}</span>
                    <span class="padded">${applicationScope.get(Constants.SELECTED_POST).getFormattedTime()}</span>
                </div>
                <div class="postContent">
                    <span>${applicationScope.get(Constants.SELECTED_POST).message}</span>
                </div>
            </div>
            <c:if test="${empty applicationScope.get(Constants.SELECTED_POST).comments.comments}">
                <span>There are no comments yet.</span>
            </c:if>
            <c:forEach items="${applicationScope.get(Constants.SELECTED_POST).comments.comments}"
                       var="item">
                <div class="commentBox">
                    <div class="commentHeader">
                        <span class="padded">#${item.commentID}</span>
                        <span class="padded">${item.commenter}</span>
                    </div>
                    <div class="commentContent">
                        <span>${item.content}</span>
                    </div>
                </div>
            </c:forEach>
            </form>
            <div>
                <a class="button" href="${pageContext.request.contextPath}/newcomment">New comment</a>
            </div>
        </div>
    </body>
</html>
