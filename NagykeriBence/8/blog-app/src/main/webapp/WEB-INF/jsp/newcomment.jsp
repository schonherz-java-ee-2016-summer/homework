<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="hu.nutty.kepzes.blogapp.utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fullos Blog - New Comment</title>
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
            <h1>New Comment!</h1>
            <form:form action='../../comments' method='POST'
                       onsubmit="return displayDialogIfEmpty('#commenterName','#commentArea')">
                <div>
                    <form:input id="commenterName" class="inputText"
                                placeholder="Commenter name" path="commenter"/>
                </div>
                <div>
                    <form:textarea id="commentArea" class="inputPost" placeholder='Enter comment here.'
                                   path="content"></form:textarea>
                    <form:input path="blogPostID" value="${command.blogPostID}" type="hidden"/>
                </div>
                <div>
                    <input class="button" type='submit' value='Submit'>
                </div>
            </form:form>
        </div>
    </body>
</html>
