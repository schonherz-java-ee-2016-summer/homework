<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
                    <spring:bind path="blogger.firstName">
                        <input id="first-name" class="inputText" name='${status.expression}' value="${status.value}"
                               type="text"
                               placeholder="First name"/>
                    </spring:bind>
                </div>
                <div>
                    <spring:bind path="blogger.lastName">
                        <input id="last-name" class="inputText" name='${status.expression}' value="${status.value}"
                               type="text"
                               placeholder="Last name"/>
                    </spring:bind>
                </div>
                <div>
                    <spring:bind path="blogger.nickName">
                        <input id="nickname" class="inputText" name='${status.expression}' value="${status.value}"
                               type="text"
                               placeholder="Nickname"/>
                    </spring:bind>
                </div>
                <div>
                    <spring:bind path="blogger.age">
                        <input id="age" class="inputText" name='${status.expression}'
                               type="text"
                               placeholder="Age" oninput="containsOnlyNumber('#age')"/>
                    </spring:bind>
                </div>
                <div>
                    <spring:bind path="blogPost.title">
                        <input id="title" class="inputText" name='${status.expression}' value="${status.value}"
                               type="text"
                               placeholder="Title"/>
                    </spring:bind>
                </div>
                <div>
                    <spring:bind path="blogPost.message">
                    <textarea id="message" class="inputPost" name='${status.expression}' value="${status.value}"
                              placeholder='Enter your blog message here.'></textarea>
                    </spring:bind>
                </div>
                <div id="interactive-label">Age must be a number.</div>
                <div>
                    <input class="button" type='submit' value='Submit'/>
                </div>
            </form>
        </div>
    </body>
</html>
