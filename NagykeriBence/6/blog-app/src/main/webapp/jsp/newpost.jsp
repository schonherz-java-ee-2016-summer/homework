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
            <form action='${pageContext.request.contextPath}/${Constants.INDEX_SESSION_KEY}' method='POST'>
                <div>
                    <input class="inputText" name='${Constants.POSTER_INPUT_NAME}'
                           value='${applicationScope.get(Constants.POSTER_INPUT_NAME)}'/>
                </div>
                <div>
                <textarea class="inputPost" name='${Constants.NEW_POST_INPUT_NAME}'
                          placeholder='Enter message here.'></textarea>
                </div>
                <div>
                    <input class="button" type='submit' value='Submit'/>
                </div>
            </form>
        </div>
    </body>
</html>
