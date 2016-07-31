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
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/forms.css">
    </head>
    <body>
        <div>
            Title: ${post.title}
        </div>
        <div>
            Creator: ${post.creator}
        </div>
        <div>
            Text:
            <pre>
                ${post.text}
            </pre>
        </div>

        <form:form class="form"  method="POST" action="add" modelAttribute="comment">

            <div class="form-element">
                <label>Comment: </label>
                <form:textarea path="content" rows="5"/>
            </div>

            <div class="form-element">
                <button class="btn" type="submit">Comment!</button>
            </div>

        </form:form>

    </body>
</html>
