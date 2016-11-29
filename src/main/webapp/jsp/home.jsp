<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Home</title>
    <style type="text/css">
        td {
            padding: 5px;
        }

        h2 {
            background-color: azure;
        }

        input {
            margin: 10px;
            padding: 5px;
            border-radius: 5px;
        }

        input[type=submit] {
            border: 0 none;
            -webkit-border-radius: 5px;
            display: inline-block;
            padding: 15px 25px;
            font-size: 15px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #4CAF50;
            border-radius: 5px;
            box-shadow: 0 9px #999;
        }
        input[type=submit]:hover {background-color: #3e8e41}

        input[type=submit]:active {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

        a:visited {
            color: red;
        }

        a:active {
            color: red;
        }

        a {
            color: red;
        }

        a:link {
            color: red;
        }

        .Task {
            margin: 50px;
            padding: 5px;
            border-radius: 5px;
        }

        .allTasks {
            background-color: bisque;
        }

        .addTasks {
            background-color: yellowgreen;
        }

        .aboutTask {
            background-color: aquamarine;
        }

        .list {
            background-color: #ffbdeb;

        }

        .toDo {
            background-color: #00ffd2;
        }

        .addList {
            background-color: yellowgreen;
        }

        .changeTask {
            background-color: yellowgreen;
        }

        .changeList {
            background-color: yellowgreen;
        }
    </style>
</head>
<body>
<div class="allTasks">
    <form action="/newTask" method="get">
        <input type="submit" value="Add Task"><br>
    </form>
    <form action="/newList" method="get">
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
                                    <form action="/about" method="get">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <input type="submit" value="View"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/deleteTask?id=${task.id}" method="post">
                                        <input type="submit" value="Delete"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/view?id=${task.id}" method="post">
                                        <input type="submit" value="Active"><br>
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
                                    <form action="/about" method="get">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <input type="submit" value="View"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/deleteTask?id=${task.id}" method="post">
                                        <input type="submit" value="Delete"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/view?id=${task.id}" method="post">
                                        <input type="submit" value="Done"><br>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <form action="/changeList" method="get">
                <input type="hidden" name="id" value="${list.list_id}">
                <input type="submit" value="Change ${list.list_name}"><br>
            </form>
            <form action="/deleteList?id=${list.list_id}" method="post">
                <input type="submit" value="Delete ${list.list_name}"><br>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
