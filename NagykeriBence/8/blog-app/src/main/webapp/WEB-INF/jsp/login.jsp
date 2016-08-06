<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fullos Blog - Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
    </head>
    <body>
        <div class="back">
            <div>
                <a href="${pageContext.request.contextPath}/"><img
                        src="${pageContext.request.contextPath}/images/fullosblog.png" alt="Fullos Blog"
                        title="Fullos Blog"></a>
            </div>
            <form action='${Constants.LOGIN_SESSION_KEY}' method='POST'
                  onsubmit="return displayDialogIfEmpty('#username','#password')">
                <div>
                    <input id="username" class="inputText" name='${Constants.LOGIN_INPUT_USERNAME}' type="text"
                           placeholder="Username (nickname)"/>
                </div>
                <div>
                    <input id="password" class="inputText" name='${Constants.LOGIN_INPUT_PASSWORD}' type="password"
                           placeholder="Password"/>
                </div>
                <div>
                    <input class="button" type='submit' value='Submit'>
                </div>
            </form>
        </div>
    </body>
</html>
