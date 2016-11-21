<jsp:useBean id="task" scope="request" type="model.Task"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
<div class="aboutTask">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <table>
        <h4>Title:</h4>
        ${task.title}<br>
        <h4>Details:</h4>
        ${task.details}<br>
        <h4>Creation time:</h4>
        ${task.startTime}
        <h4>End time:</h4>
        ${task.endTime}
        <h4>List:</h4>
        ${task.listTask.list_name}
    </table>
</div>
</body>
</html>
