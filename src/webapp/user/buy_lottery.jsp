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
    <title>购买彩票</title>
    <link rel="icon" href="../pic/favicon.ico">
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/jumbotron.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/offcanvas.css"/>" rel="stylesheet">
    <%--<script>check function</script>--%>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-8">
            <div class="jumbotron">
                <h3>购买彩票</h3>
                <hr>
                <form class="form-group form-inline" action="<c:url value="/buy_result"/>" method="post">
                    <label class="control-label">期数</label>
                    <span class="form-control" style="background-color: #e7e7e7" onselectstart="return false;">
                        ${sessionScope.phase}
                    </span>
                    <hr>

                    <label class="control-label" style="color: red">红球</label>
                    <label for="red1" class="sr-only"></label>
                    <input type="text" name="red1" id="red1" class="form-control" style="width:3em"/>
                    <label for="red2" class="sr-only"></label>
                    <input type="text" name="red2" id="red2" class="form-control" style="width:3em"/>
                    <label for="red3" class="sr-only"></label>
                    <input type="text" name="red3" id="red3" class="form-control" style="width:3em"/>
                    <label for="red4" class="sr-only"></label>
                    <input type="text" name="red4" id="red4" class="form-control" style="width:3em"/>
                    <label for="red5" class="sr-only"></label>
                    <input type="text" name="red5" id="red5" class="form-control" style="width:3em"/>
                    <label for="red6" class="sr-only"></label>
                    <input type="text" name="red6" id="red6" class="form-control" style="width:3em"/>
                    <hr>

                    <label class="control-label" style="color: blue">蓝球</label>
                    <label for="blue" class="sr-only"></label>
                    <input type="text" name="blue" id="blue" class="form-control" style="width:3em"/>
                    <hr>

                    <label class="control-label">金额</label>
                    <label for="amount" class="sr-only"></label>
                    <input type="text" name="amount" id="amount" class="form-control"/>
                    <hr>

                    <button class="btn btn-primary btn-block" style="width:6em" type="submit">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script src="<c:url value="/bootstrap/modules/jquery.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>