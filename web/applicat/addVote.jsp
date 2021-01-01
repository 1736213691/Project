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
    <title>发布投票活动</title>
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
            <h3 class="panel-title">
                <b>发布投票</b>
            </h3>
        </div>
        <div class="panel-body" style="padding: 5px; ">
    <table class="table table-bordered table-hover table-condensed table-margin table-width">
        <tbody class="table-hover">
        <tr><td>标题:</td><td><input type="text" id="title" style="width: 100%;"></td></tr>
        <tr><td>正文:</td><td><textarea id="content" style="height: 500px;width: 100%;resize: none;"></textarea></td></tr>
        </tbody>
    </table>

        </div>
    </div>
    <div>
        <input class="btn btn-info" type="button" value="添加" onclick="return addVote()">
        <input class="btn btn-info" type="button" value="返回投票界面" onclick="location='/ov/SearchVoteListServlet'">
    </div>
</div>
<jsp:include page="../struct/tail.jsp" />
</body>
</html>
