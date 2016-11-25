<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <title>New Task</title>
</head>
<body>
<div class="addTasks">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/newTask" method="post">
        <input type="text" name="new_task" placeholder="add task" required>
        <input type="text" name="new_description" placeholder="add description" >
        <label>
            <input type="date" name="new_currentTime">
        </label>
        <label>
            <input type="date" name="new_startTime">
        </label>
        <select name="new_list">
            <c:forEach items="${ListTasks}" var="listTasks">
                <option value="${listTasks.list_id}">${listTasks.list_name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add Task"><br>
    </form>
</div>
</body>
</html>
