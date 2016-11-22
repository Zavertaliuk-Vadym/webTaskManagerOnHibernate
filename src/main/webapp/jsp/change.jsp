<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../css/mystyle.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>
<div class="aboutTask">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/about.jsp">
        <input type="submit" value="change"><br>
        <input type="text" name="new_description" placeholder="add description">
        <input type="text" name="new_description" placeholder="add description">
        <input type="text" name="new_description" placeholder="add description">
        <input type="text" name="new_description" placeholder="add description">
        <input type="text" name="new_description" placeholder="add description">
    </form>
</div>
</body>
</html>
