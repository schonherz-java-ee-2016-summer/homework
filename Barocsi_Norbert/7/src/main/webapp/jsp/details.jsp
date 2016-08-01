<%--
  Created by IntelliJ IDEA.
  User: Mindfield
  Date: 2016. 07. 31.
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>${post.title}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/resources/css/button.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/forms.css">
    </head>
    <body>

        <div class="form">
            <div class="form-element">Title: ${post.title}</div>
            <div class="form-element">Creator: ${post.creator}</div>
            <div class="form-element">Text: ${post.text}</div>
        </div>

        <c:forEach items="${post.comments}" var="listelement">
            <div class="form">
                <div class="form-element">Comment Date: ${listelement.date}</div>
                <div class="form-element">Comment Content: ${listelement.content}</div>
            </div>
        </c:forEach>

        <form:form class="form"  method="POST" action="add" modelAttribute="comment">

            <div>
                <form:hidden path="blogIdentity"/>
            </div>
            <div class="form-element">
                <label>Comment: </label>
                <form:textarea path="content" rows="5"/>
            </div>
            <%--<input type="hidden" name="identity" value="${post.identity}"/>--%>
            <div class="form-element">
                <button class="btn" type="submit">Comment!</button>
            </div>

        </form:form>

    </body>
</html>
