<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../pic/favicon.ico">
    <title>个人彩票系统</title>
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/jumbotron.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/offcanvas.css"/>" rel="stylesheet">
    <c:if test="${sessionScope.loginResult=='fail'||sessionScope.loginResult==''||sessionScope.loginResult==null}">
        <script>
            function check() {
                alert('请登录!');
                return false;
            }
        </script>
    </c:if>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-8">
            <div class="jumbotron">
                <h3>个人彩票系统</h3>
                <hr>

                <p><a class="btn btn-primary" href="buy" role="button" onclick="return check();">购买彩票</a></p>

            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script src="<c:url value="/bootstrap/modules/jquery.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
