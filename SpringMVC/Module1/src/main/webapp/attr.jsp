<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>测试数据传递</title>
</head>
<body>


<h1>数据传递</h1>
<h2>${requestScope.username}</h2>
<h2>${username}</h2>
<hr color="blue">
<h3>${requestScope.user.id}</h3>
<h3>${requestScope.user.name}</h3>
<h3>${requestScope.user.age}</h3>
<h3><fmt:formatDate value="${requestScope.user.bir}" pattern="yyyy-MM-dd"/></h3>
<hr color="green">
<%--var别名--%>
<c:forEach items="${requestScope.users}" var="user">
    id:${user.id} == ${user.name} == ${user.age} == <fmt:formatDate value="${user.bir}"/> <br>
</c:forEach>
<hr color="black">
<h3>地址栏:${param.name}</h3>
<h3>id:${sessionScope.user.id}</h3>
<h3>name:${sessionScope.user.name}</h3>
<h3>age:${sessionScope.user.age}</h3>
<h3>bir:${sessionScope.user.bir}</h3>


</body>
</html>
