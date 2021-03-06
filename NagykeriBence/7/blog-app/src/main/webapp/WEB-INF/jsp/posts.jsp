<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>${selected_post.author.nickName}, ${selected_post.title}
            - Fullos Blog Post.</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
    </head>
    <body>
        <div class="back">
            <div>
                <a href="/"><img
                        src="<c:url value="/resources/images/fullosblog.png"/>" alt="Fullos Blog"
                        title="Fullos Blog"></a>
            </div>
            <div class="postBox">
                <div class="postHeader">
                    <span class="padded">#${selected_post.postID}</span>
                    <span class="padded">${selected_post.author.nickName}</span>
                    <span class="padded">${selected_post.title}</span>
                    <span class="padded">${selected_post.getFormattedTime()}</span>
                </div>
                <div class="postContent">
                    <span>${selected_post.message}</span>
                </div>
            </div>
            <c:if test="${empty selected_post.comments.comments}">
                <span>There are no comments yet.</span>
            </c:if>
            <c:forEach items="${selected_post.comments.comments}"
                       var="item" varStatus="loop">
                <div class="commentBox">
                    <div class="commentHeader">
                        <span class="padded">#${loop.index + 1}</span>
                        <span class="padded">${item.commenter}</span>
                        <span class="padded">${item.getFormattedTime()}</span>
                    </div>
                    <div class="commentContent">
                        <span>${item.content}</span>
                    </div>
                </div>
            </c:forEach>
            </form>
            <div>
                <a class="button" href="<c:url value="/post/${selected_post.postID}/newcomment" />">New comment</a>
            </div>
        </div>
    </body>
</html>
