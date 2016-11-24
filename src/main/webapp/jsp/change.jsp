<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <title>Change old task</title>
</head>

<body>
<div class="aboutTask">
    <form action="/changeTask" method="post">
        <input type="hidden" name="taskId" value="${task.id}"><br>
        <input type="text" name="title" value="${task.title}" placeholder="add title"><br>
        <input type="text" name="details" value="${task.details}" placeholder="add details"><br>
        <input type="text" name="startTime" value="${task.startTime}" placeholder="add start time"><br>
        <input type="text" name="endTime" value="${task.endTime}" placeholder="add end time"><br>
        <input type="text" name="listId" value="${task.tasksList.list_name}" placeholder="add list"><br>
        <input type="submit" value="change"><br>
    </form>
</div>
</body>
</html>
