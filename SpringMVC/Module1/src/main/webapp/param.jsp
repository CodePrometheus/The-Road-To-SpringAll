<%--
  Created by IntelliJ IDEA.
  User: Star
  Date: 2020/8/11
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试表单</title>
</head>
<body>


<h1>参数接收</h1>
<form action="${pageContext.request.contextPath}/param/test" method="post">
    name:<input type="text" name="name"><br>
    price:<input type="text" name="price"><br>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
