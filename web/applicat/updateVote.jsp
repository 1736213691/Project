<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/28
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/25
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票详情</title>
    <link rel="stylesheet" href="/ov/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/ov/css/main.css">
    <link rel="stylesheet" href="/ov/css/votelist.css">
    <script src="/ov/javascript/identify.js"></script>
    <script src="/ov/javascript/ajax.js"></script>
    <script src="/ov/javascript/page.js"></script>
    <script src="/ov/bootstrap/js/jquery.js"></script>
    <script src="/ov/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="mainbody">
<jsp:include page="../struct/head.jsp" />
<div align="center">
    <div class="panel panel-info" style="margin: 30px">
        <div class="panel-heading">
            <h2 class="panel-title">
                <b>标题：${requestScope.currentVote.title}</b>
            </h2>
        </div>
        <div class="panel-body" style="padding: 5px; ">
    <table class="table table-bordered table-hover table-condensed">
        <tbody class="table-hover">
        <tr><td>发起者:</td><td>${requestScope.currentVote.name}</td></tr>
        <tr><td>投票ID:</td><td id="putId">${requestScope.currentVote.id}</td></tr>
        <tr><td>标题:</td><td><input type="text" id="title" style="width: 100%;" value="${requestScope.currentVote.title}"></td></tr>
        <tr><td>正文:</td><td><textarea id="content" style="height: 500px;width: 100%;resize: none;">${requestScope.currentVote.content}</textarea></td></tr>
        <tr><td>票数:</td><td>${requestScope.currentVote.count}</td></tr>
        </tbody>
    </table>
            </div></div>
    <div>
        <input class="btn btn-info" type="button" value="修改" onclick="return updateVote()">
        <input class="btn btn-info" type="button" value="删除" onclick="location='/ov/DeleteVoteServlet?id='+${requestScope.currentVote.id}">
        <input class="btn btn-info" type="button" value="返回投票界面" onclick="location='/ov/SearchVoteListServlet'">
    </div>
</div>
<jsp:include page="../struct/tail.jsp" />
</body>
</html>

