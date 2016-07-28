<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fullos Blog</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
    </head>
    <body>
        <div class="back">
            <div>
                <a href="/"><img
                        src="<c:url value="/resources/images/fullosblog.png"/>" alt="Fullos Blog"
                        title="Fullos Blog"></a>
            </div>
            <div>
                <a class="button" href="post/new">Create new post</a>
            </div>
            <c:if test="${empty index}">
                <span>There are no posts yet.</span>
            </c:if>
            <c:forEach items="${index}" var="item">
                <div class="postBox">
                    <div id="noBorder" class="postHeader">
                        <a class="padded"
                           href="/posts?p=${item.postID}">#${item.postID}
                            - ${item.author.nickName} - ${item.title}</a>
                        <span class="padded">${item.getFormattedTime()}</span>
                    </div>
                </div>
            </c:forEach>
            </form>
        </div>
    </body>
</html>
