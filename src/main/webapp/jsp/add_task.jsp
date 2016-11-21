<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
</head>
<body>
<div class="addTasks">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/newTask">
        <input type="text" name="new_task" placeholder="add task" required>
        <input type="text" name="new_description" placeholder="add description">
        <input type="text" name="new_currentTime" placeholder="add current time">
        <input type="text" name="new_list" placeholder="add list">
        <input type="submit" value="Add Task"><br>
    </form>
</div>
</body>
</html>
