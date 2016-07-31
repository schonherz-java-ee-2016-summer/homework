<%--
  Created by IntelliJ IDEA.
  User: Mindfield
  Date: 2016. 07. 31.
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Posts</title>
        <link rel="stylesheet" type="text/css" href="/css/button.css">
        <link rel="stylesheet" type="text/css" href="/css/forms.css">
    </head>
    <body>
        <a class="form-element" href="/post/create">
            <button class="btn" type="submit">New Post!</button>
        </a>
        <c:forEach items="${posts}" var="element">

            <div class="form">
                <span class="form-element">${element.identity}</span>
                <span class="form-element">${element.creator}</span>
                <span class="form-element">${element.date}</span>

                <a class="form-element" href="post/details/${element.identity}">
                    <button class="btn">Show Post!</button>
                </a>
            </div>

        </c:forEach>
    </body>
</html>