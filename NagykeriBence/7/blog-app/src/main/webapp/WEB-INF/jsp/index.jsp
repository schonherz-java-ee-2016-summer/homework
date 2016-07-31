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
                <a href="<c:url value="/" />">
                    <img src="<c:url value="/resources/images/fullosblog.png"/>" alt="Fullos Blog" title="Fullos Blog">
                </a>
            </div>
            <div>
                <a class="button" href="<c:url value="/post/new" />">Create new post</a>
            </div>
            <c:if test="${empty posts}">
                <span>There are no posts yet.</span>
            </c:if>
            <c:forEach items="${posts}" var="item">
                <div class="postBox">
                    <a class="no-link" href="/posts?post=${item.postID}">
                        <div id="noBorder" class="postHeader">
                            <span class="padded">#${item.postID} - ${item.author.nickName} - ${item.title}</span>
                            <span class="padded">${item.getFormattedTime()}</span>
                        </div>
                    </a>
                </div>
            </c:forEach>
            </form>
        </div>
    </body>
</html>
