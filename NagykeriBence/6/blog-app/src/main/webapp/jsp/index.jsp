<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fullos Blog</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="back">
            <div>
                <a href="${pageContext.request.contextPath}/"><img
                        src="${pageContext.request.contextPath}/images/fullosblog.png" alt="Fullos Blog"
                        title="Fullos Blog"></a>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/post/new">Create new post.</a>
            </div>
            <c:if test="${empty applicationScope.get(Constants.POST_LIST)}">
                <span>There are no posts yet.</span>
            </c:if>

            <c:forEach items="${applicationScope.get(Constants.POST_LIST)}" var="item">
                <div class="box">
                    <div class="postHeader">
                        <a href="${pageContext.request.contextPath}/posts?p=${item.getPostID()}">#${item.getPostID()}
                            - ${item.getAuthor().getNickName()} - ${item.getTitle()}</a>
                        <span>${item.getTime()}</span>
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
