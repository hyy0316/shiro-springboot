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
    <h1>系统主页v1.0 </h1>
    <a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
    <ul class="li"><a href="">用户管理</a></ul>
    <ul class="li"><a href="">商品管理</a></ul>
    <ul class="li"><a href="">订单管理</a></ul>
    <ul class="li"><a href="">物流管理</a></ul>
    <ul class="li"><a href="">权限管理</a></ul>
</body>
</html>