<%@page contentType="text/html; utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>注册 </h1>
    <form action="${pageContext.request.contextPath}/user/register" method="post">
        <span>用户名：</span><input type="text" name="username" value="" ><br/>
        <span>密码：</span><input type="password" name="password" value="" ><br/>
       <input type="submit" value="注册">

    </form>

</body>
</html>