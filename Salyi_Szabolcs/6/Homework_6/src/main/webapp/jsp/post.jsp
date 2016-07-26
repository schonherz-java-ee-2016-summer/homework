<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
            <title>Blog post ${pageContext.request.requestURL.substring(pageContext.request.requestURL.length()-1)}</title>
    </head>
    <body>
            <c:forEach items="${posts}" var="element">
                <c:if test="${pageContext.request.requestURL.substring(pageContext.request.requestURL.length()-1) == element.getId()}">
                    <h1>Add a comment to post ${element.getTitle()}!</h1>
                    <div>Post ID: ${element.getId()}</div>
                    <div>Post Author: ${element.getAuthor()}</div>
                    <div>Post Time: ${element.getDate()}</div>
                    <div>Post Title: ${element.getTitle()}</div>
                    <div>Content: ${element.getContent()}</div>
                    <c:forEach items="${element.comments}" var="comment">
                        <div>Comment ID: ${commment.getId()}</div>
                        <div>Comment Date: ${comment.getDate()}</div>
                        <div>Comment Content: ${commment.getContent()}</div>
                    </c:forEach>
                    <input type="hidden" name="id" value="${element.getId()}"/>
                </c:if>
            </c:forEach>

            <form method="post" action="/addcomment">


                    <div>
                        <span>Add a new Comment!</span>
                    </div>
                    <div>
                        <label for="new-post-content">Comment Content:</label>
                        <input id="new-post-content" name="content" type="text">
                    </div>

                    <div>
                        <button type="submit">Add Comment</button>
                    </div>
            </form>
    </body>
</html>
