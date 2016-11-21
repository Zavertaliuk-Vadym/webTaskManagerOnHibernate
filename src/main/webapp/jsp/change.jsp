<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
<div class="aboutTask">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/change">
        <input type="submit" value="Add Task"><br>
        <table>
            <h4>Title:</h4>
            ${task.title}<br>
            <input type="text" name="new_task" placeholder="add task" required>
            <h4>Details:</h4>
            ${task.details}<br>
            <input type="text" name="new_description" placeholder="add description">
        </table>
    </form>
</div>
</body>
</html>
