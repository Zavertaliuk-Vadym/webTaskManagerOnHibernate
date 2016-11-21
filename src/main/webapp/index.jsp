<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<style type="text/css">
    td {
        padding: 5px;
    }

    input {
        margin: 10px;
        padding: 5px;
        border-radius: 5px;
    }

    input[type=submit] {
        padding: 5px 15px;
        background: #cccccc;
        border: 0 none;
        cursor: move;
        -webkit-border-radius: 5px;
        border-radius: 5px;
    }

    a:visited{
        color: red;
    }

    a:active{
        color: red;
    }

    a{
        color: red;
    }

    a:link{
        color: red;
    }
    .allTasks{
        background-color: bisque;
    }
    .addTasks{
        background-color: yellowgreen;
    }
    .aboutTask{
        background-color:aquamarine ;
    }

    .list{
        background-color: aqua;
        border-radius: 2px;
    }
    .toDo{
        background-color: yellowgreen;
    }
</style>
<body>
<div class="allTasks">
    <input type="submit" value="Add Task" onclick="window.location='jsp/add_task.jsp'" style="font-size:12px"><br>
    <h1>List1</h1>

    <h2>TO DO</h2>
    <div class="list">
        <table>
            <c:forEach items="${taskList}" var="task">
                <tr>
                    <c:if test="${!task.view}">
                            <td>
                                    ${task.title}
                            </td>
                            <td>
                                <a href="/messages?task=${task.id}">
                                    <i class="material-icons" style="font-size:32px; color: blue;">pageview</i>
                                </a>
                            </td>
                            <td>
                                <a href="/delete?task=${task.id}">
                                    <i class="material-icons" style="font-size:32px;color: red">gavel</i>
                                </a>
                            </td>
                            <td>
                                <a href="/view?task=${task.id}">
                                    <i class="material-icons" style="font-size:32px;color: black">indeterminate_check_box</i>
                                </a>
                            </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h2>Done Tasks</h2>
    <div class="toDo">
        <table>
            <c:forEach items="${taskList}" var="task">
                <tr>
                    <c:if test="${task.view}">
                        <td>
                                ${task.title}
                        </td>
                        <td>
                            <a href="/messages?task=${task.id}">
                                <i class="material-icons" style="font-size:32px; color: blue;">pageview</i>
                            </a>
                        </td>
                        <td>
                            <a href="/delete?task=${task.id}">
                                <i class="material-icons" style="font-size:32px;color: red">gavel</i>
                            </a>
                        </td>
                        <td>
                            <a href="/view?task=${task.id}">
                                <i class="material-icons" style="font-size:32px;color: black">check_box</i>

                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
