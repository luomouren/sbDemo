<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2017-12-17
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <script type="text/css" src="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"></script>
    <script type="text/css" src="/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"></script>

    <script type="application/javascript" src="/static/jquery/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="/js/test/test.js"></script>
</head>
<body>
    <button onclick="login();">登录获取Token</button>
    <input type="text" id="accessToken"/>
    <button onclick="testToken();">带Token请求</button>
</body>
</html>
