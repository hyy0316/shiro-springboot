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
    <h1>登录 </h1>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <span>用户名：</span><input type="text" name="userName" value="" ><br/>
        <span>密码：</span><input type="text" name="password" value="" ><br/>
       <input type="submit" value="登录">

    </form>

</body>
</html>