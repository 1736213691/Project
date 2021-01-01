<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/25
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票详情</title>
    <link rel="stylesheet" href="/ov/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/ov/css/main.css">
    <link rel="stylesheet" href="/ov/css/votelist.css">
    <script src="/ov/javascript/identify.js"></script>
    <script src="/ov/javascript/page.js"></script>
    <script src="/ov/bootstrap/js/jquery.js"></script>
    <script src="/ov/bootstrap/js/bootstrap.min.js"></script>

    <script src="/ov/javascript/ajax.js"></script>
</head>
<body class="mainbody">
<jsp:include page="../struct/head.jsp" />

<div align="center">
    <div class="panel panel-info" style="margin: 30px">
        <div class="panel-heading">
            <h3 class="panel-title">
                <b>标题：${requestScope.currentVote.title}</b>
            </h3>
        </div>
        <div class="panel-body" style="padding: 5px; ">
    <table class="table table-bordered table-hover table-condensed">
        <tbody class="table-hover">
        <tr><td>发起者:</td><td>${requestScope.currentVote.name}</td></tr>
        <tr><td>活动ID:</td><td id="putId">${requestScope.currentVote.id}</td></tr>
        <tr><td>票数:</td><td id="count">${requestScope.currentVote.count}</td></tr>
        <tr><td>正文:</td><td><textarea id="content" style="height: 500px;width: 100%;resize: none;" readonly="readonly">${requestScope.currentVote.content}</textarea></td></tr>
        <tr style="background-color: #bce8f1;opacity: 80%"><td>投票用户ID</td><td>投票时间(只显示最近前30位)</td></tr>
        <c:choose>
            <c:when test="${not empty requestScope.uservotelist}">
                <c:forEach items="${requestScope.uservotelist}" var="uservote">
                    <tr class="vote">
                        <td>${uservote.name}</td>
                        <td>${uservote.date}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="2" align="center">还没有人进行投票</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
            </div>
            </div>
<div>
    <input class="btn btn-info" type="button" value="投票" onclick="return putVote()">
    <input class="btn btn-info" type="button" value="返回投票界面" onclick="location='/ov/SearchVoteListServlet'">
    </div>
</div>
<jsp:include page="../struct/tail.jsp" />
</body>
</html>
