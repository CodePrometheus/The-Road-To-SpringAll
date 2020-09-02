<%--
  Created by IntelliJ IDEA.
  User: Star
  Date: 2020/8/24
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/reg.action">
    UserId<input type="text" name="user.id"/><br>
    UserName<input type="text" name="user.name"/><br>
    UserAge<input type="text" name="user.age"/><br>
    <input type="submit" value="reg">
</form>
</body>
</html>
