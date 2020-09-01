<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">

    <input type="file" name="img"/>
    <input type="submit" value="上传文件"/>

</form>

<h1>文件下载</h1>
<a href="${pageContext.request.contextPath}/file/download?fileName=a.txt">a.txt</a>
<a href="${pageContext.request.contextPath}/file/download?fileName=b.exe">b.exe</a>

</body>
</html>
