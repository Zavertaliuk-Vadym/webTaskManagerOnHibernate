<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <title>New List</title>
</head>
<body>
<div class="addList">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/newList" method="post">
        <input type="text" name="name" placeholder="add name" required>
        <input type="submit" value="Add List"><br>
    </form>
</div>
</body>
</html>
