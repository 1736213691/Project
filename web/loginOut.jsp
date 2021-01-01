<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/13
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="2;login.html">
    <title>安全退出</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <%
        session.invalidate();
    %>
    退出成功,2秒后将跳转到登录页面！
</body>
</html>
