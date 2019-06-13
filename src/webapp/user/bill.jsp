<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/pic/favicon.ico"/>">
    <title>Jumbotron Template for Bootstrap</title>
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap/modules/jumbotron.css"/>" rel="stylesheet">
</head>

<body>

<%@ include file="header.jsp" %>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-8 column">
                    <h4><b> 账单信息 </b></h4>
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <td>账单编号</td>
                            <td>${sessionScope.billId}</td>
                        </tr>
                        <tr>
                            <td>付款人</td>
                            <td>${sessionScope.payerName}</td>
                        </tr>
                        <tr>
                            <td>收款人</td>
                            <td>${sessionScope.payeeName}</td>
                        </tr>
                        <tr>
                            <td>生成时间</td>
                            <td>${sessionScope.createTime}</td>
                        </tr>
                        <tr>
                            <td>金额</td>
                            <td>${sessionScope.amount}</td>
                        </tr>
                        <tr>
                            <td>手续费</td>
                            <td>${sessionScope.charge}</td>
                        </tr>
                        <tr>
                            <td>交易是否完成</td>
                            <td>
                                <c:if test="${sessionScope.isFinish=='true'}">
                                    完成
                                </c:if>
                                <c:if test="${sessionScope.isFinish=='false'}">
                                    未完成
                                </c:if>
                            </td>
                        </tr>
                        <c:if test="${sessionScope=='true'}">
                            <tr>
                                <td>完成时间</td>
                                <td>${sessionScope.finishDate}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <td>详细信息</td>
                            <td>${sessionScope.information}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4 column">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>
                                编号
                            </th>
                            <th>
                                产品
                            </th>
                            <th>
                                交付时间
                            </th>
                            <th>
                                状态
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                1
                            </td>
                            <td>
                                TB - Monthly
                            </td>
                            <td>
                                01/04/2012
                            </td>
                            <td>
                                Default
                            </td>
                        </tr>
                        <tr class="success">
                            <td>
                                1
                            </td>
                            <td>
                                TB - Monthly
                            </td>
                            <td>
                                01/04/2012
                            </td>
                            <td>
                                Approved
                            </td>
                        </tr>
                        <tr class="error">
                            <td>
                                2
                            </td>
                            <td>
                                TB - Monthly
                            </td>
                            <td>
                                02/04/2012
                            </td>
                            <td>
                                Declined
                            </td>
                        </tr>
                        <tr class="warning">
                            <td>
                                3
                            </td>
                            <td>
                                TB - Monthly
                            </td>
                            <td>
                                03/04/2012
                            </td>
                            <td>
                                Pending
                            </td>
                        </tr>
                        <tr class="info">
                            <td>
                                4
                            </td>
                            <td>
                                TB - Monthly
                            </td>
                            <td>
                                04/04/2012
                            </td>
                            <td>
                                Call in to confirm
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <a href="<c:url value="/file/pdf/${sessionScope.billId}.pdf"/>">下载账单</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>


<script src="<c:url value="/bootstrap/modules/jquery.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>
