<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fullos Blog - New Blog Post</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/validator.js"/>"></script>
    </head>
    <body>
        <div class="back">
            <div>
                <a href="/"><img
                        src="<c:url value="/resources/images/fullosblog.png"/>" alt="Fullos Blog"
                        title="Fullos Blog"></a>
            </div>
            <form action='<c:url value="/index" />' method='POST'
                  onsubmit="return displayDialogIfEmpty('#first-name','#last-name', '#nickname', '#age', '#title', '#message')">
                <div>
                    <input id="first-name" class="inputText" name='${Constants.POSTER_INPUT_FIRST_NAME}' type="text"
                           placeholder="First name"/>
                </div>
                <div>
                    <input id="last-name" class="inputText" name='${Constants.POSTER_INPUT_LAST_NAME}' type="text"
                           placeholder="Last name"/>
                </div>
                <div>
                    <input id="nickname" class="inputText" name='${Constants.POSTER_INPUT_NICKNAME}' type="text"
                           placeholder="Nickname"/>
                </div>
                <div>
                    <input id="age" class="inputText" name='${Constants.POSTER_INPUT_AGE}' type="text"
                           placeholder="Age" oninput="containsOnlyNumber('#age')"/>
                </div>
                <div>
                    <input id="title" class="inputText" name='${Constants.POST_TITLE}' type="text" placeholder="Title"/>
                </div>
                <div>
                <textarea id="message" class="inputPost" name='${Constants.NEW_POST_INPUT_NAME}'
                          placeholder='Enter your blog message here.'></textarea>
                </div>
                <div id="interactive-label">Age must be a number.</div>
                <div>
                    <input class="button" type='submit' value='Submit'/>
                </div>
            </form>
        </div>
    </body>
</html>
