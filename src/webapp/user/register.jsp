<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>注册</title>
    <link rel="icon" href="../pic/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/signin.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/jumbotron.css"/>" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=".">个人彩票系统</a>
        </div>
    </div>
</nav>
<div class="container">
    <form class="form-signin" method="post" action="<c:url value="/register_servlet"/>">
        <h2 class="form-signin-heading">注册信息</h2>
        <hr>
        <label for="username" class="sr-only">请输入用户名</label>
        <input type="text" id="username" class="form-control" placeholder="请输入用户名" required autofocus>
        <label for="password" class="sr-only">请输入密码</label>
        <input type="password" id="password" class="form-control" placeholder="请输入密码" required>
        <label for="password2" class="sr-only">请再次输入密码</label>
        <input type="password" id="password2" class="form-control" placeholder="请再次输入密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">确认注册信息</button>
    </form>
</div>
<script src="<c:url value="/bootstrap/modules/jquery.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
