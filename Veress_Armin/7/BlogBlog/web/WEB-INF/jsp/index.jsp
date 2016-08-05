<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Available Blogs</title>
    </head>
    <body>
        <div>
            <div>
                <h1> Available Blogs</h1>
            </div>
            <div>
            <form method="get" action="/post/new">
                <c:forEach items="${posts}" var="item">
                    <div>
                        <div>
                            <a 
                               href="/posts?p=${item.id}">${item.id}
                                  ${item.author}   ${item.title}</a>
                            <span>${item.date}</span>
                        </div>
                    </div>
                </c:forEach>
                <div>
                    <button type="submit" style="width:100px;height:50px;font-size:15px">New post</button>
                </div>
            </form>
        </div>
    </body>
</html>
