<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title align="center">New Comment</title>
</head>
<body>
<div align="center">
    <h1>New Comment!</h1>
    <form method="POST" action="/comment/add">
        <div>
            Name: <input type="text" name='commenter_name' type="text"
                         placeholder="Commenter name"/>
        </div>
        <div>
            Comment: <textarea name='commenter_comment' style="width:250px;height:150px;"
                               placeholder='Enter comment here.'></textarea>
        </div>
        <div>
            <button type="submit" style="width:100px;height:50px;font-size:15px">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
