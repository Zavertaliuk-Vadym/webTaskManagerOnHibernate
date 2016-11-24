<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/24/16
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New List</title>
</head>
<body>
<form action="/newList" method="post">
    <input type="text" name="name" placeholder="add list" required>
    <input type="submit" value="Add Task"><br>
</form>
</body>
</html>
