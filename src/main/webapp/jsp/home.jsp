<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Home</title>
</head>
<body>
<div class="allTasks">
    <form action="/add_task" method="get">
        <input type="submit" value="Add Task"><br>
    </form>
    <form action="/add_list" method="get">
        <input type="submit" value="Add List"><br>
    </form>
    <c:forEach items="${ListTasks}" var="list">
        <div class="Task">
            <h2>${list.list_name}</h2>
            <h3>TO DO</h3>
            <div class="list">
                <table>
                    <c:forEach items="${list.tasks}" var="task">
                        <tr>
                            <c:if test="${!task.view}">
                                <td>
                                        ${task.title}
                                </td>
                                <td>
                                    <a href="/about?task=${task.id}">
                                        <i class="material-icons" style="font-size:32px; color: blue;">pageview</i>
                                    </a>
                                </td>
                                <td>
                                    <form action="/deleteTask?task=${task.id}" method="post">
                                        <input type="submit" value="Delete"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/view?task=${task.id}" method="post">
                                        <input type="submit" value="Active" ><br>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <h3>Done Tasks</h3>
            <div class="toDo">
                <table>
                    <c:forEach items="${list.tasks}" var="task">
                        <tr>
                            <c:if test="${task.view}">
                                <td>
                                        ${task.title}
                                </td>
                                <td>
                                    <a href="/about?task=${task.id}">
                                        <i class="material-icons" style="font-size:32px; color: blue;">pageview</i>
                                    </a>
                                </td>
                                <td>
                                    <form action="/deleteTask?task=${task.id}" method="post">
                                        <input type="submit" value="Delete" ><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/view?task=${task.id}" method="post">
                                        <input type="submit" value="Done" ><br>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <form action="/deleteList?task=${list.list_id}" method="post">
                <input type="submit" value="Delete ${list.list_name}"><br>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
