<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>">个人彩票系统</a>
        </div>
        <c:if test="${sessionScope.loginResult==''||sessionScope.loginResult==null||sessionScope=='false'}">
            <c:if test="${sessionScope.loginResult=='false'}">
                <script>
                    alert("${sessionScope.errorMessage}");
                </script>
            </c:if>
            <div id="navbar" class="navbar-collapse collapse">
                <form class="navbar-form navbar-right" method="POST" action="<c:url value="/login"/>">
                    <div class="form-group">
                        <label for="username" class="sr-only">username</label>
                        <input id="username" name="username" type="text" placeholder="Username" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password" class="sr-only">password</label>
                        <input id="password" name="password" type="password" placeholder="Password"
                               class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">登录</button>
                    <a class="btn btn-success" href="<c:url value="/register"/>" role="button">注册</a>
                </form>
            </div>
        </c:if>
        <c:if test="${sessionScope.loginResult=='true'}">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${sessionScope.username}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人中心</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="<c:url value="/logout"/>">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </c:if>
    </div>
</nav>