<%-- 
    Document   : viewpost
    Created on : Jul 31, 2016, 5:46:45 PM
    Author     : 101001951
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Selected Post.</title>
    </head>
    <body>
        <h1 align="center">${selected_post.getAuthor()}, ${selected_post.getTitle()}</h1>
        <div align="center">
            <span>${selected_post.getId()}</span>
            <span>${selected_post.getAuthor()}</span>
            <span>${selected_post.getTitle()}</span>
            <span>${selected_post.getDateOfPosting()}</span>
        </div>
        <div align="center">
           <span>${selected_post.getContentOfPost()}</span>
        </div>
        <forEach var="comment" items=${post_comments}>
            <div>
                <div>
                    <span>${comment.getId()}</span>
                    <span>${comment.getCommenter()}</span>
                </div>
                <div>
                    <span>${comment.getContentOfComment()}</span>
                </div>
            </div>
        </forEach>
        <div>
            <a href="newcomment">New comment</a>
        </div>
    </body>
</html>
