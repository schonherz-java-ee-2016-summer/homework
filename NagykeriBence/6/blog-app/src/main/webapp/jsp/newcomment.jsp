<%--
  Created by IntelliJ IDEA.
  User: Nutty
  Date: 2016.07.21.
  Time: 13:13
--%>
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
            <h1>New Comment!</h1>
            <form action='${Constants.COMMENTS_SESSION_KEY}' method='POST'>
                <div>
                    <input class="inputText" name='${Constants.COMMENTER_INPUT_NAME}'
                           value='${applicationScope.get(Constants.COMMENTER_INPUT_NAME)}'></input>
                </div>
                <div>
                    <textarea class="inputPost" name='${Constants.NEW_COMMENT_INPUT_NAME}'
                              placeholder='Enter comment here.'></textarea>
                </div>
                <div>
                    <input class="button" type='submit' value='Submit'></input>
                </div>
            </form>
        </div>
    </body>
</html>
