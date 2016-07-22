<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body>
        <div class="back">
            <a href="${pageContext.request.contextPath}/post/new">Create new post.</a>
            <c:if test="${empty applicationScope.get(Constants.POSTLIST)}">
                <span>There are no posts yet.</span>
            </c:if>

            <c:forEach items="${applicationScope.get(Constants.POSTLIST)}" var="item">
                <div class="box">
                    <div class="postHeader">
                        <a href="${pageContext.request.contextPath}/posts?p=${item.getPostID()}" >#${item.getPostID()} - ${item.getAuthor().getFirstName()}</a>
                    </div>
                    <div class="postContent">
                    <span>${item.getMessage()}</span>
                    </div>
                </div>
            </c:forEach>
            </form>
        </div>
    </body>
</html>
