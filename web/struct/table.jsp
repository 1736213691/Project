<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/12/28
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<div class="panel panel-info" style="margin: 30px">
    <div class="panel-heading">
        <h3 class="panel-title">
            <b>投票活动</b>
        </h3>
    </div>
<div class="panel-body" style="padding: 5px; ">
    <table class="table table-bordered table-hover table-condensed" style="padding: 0px; margin: 0px;">
        <thead class="kk">
        <td><span>活动ID</span></td>
        <td><span>标题</span></td>
        <td><span>发起者</span></td>
        <td><span>票数</span></td>
        <td><span>发起时间</span></td>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty requestScope.voteList}">
                <c:forEach items="${requestScope.voteList}" var="vote">
                    <tr class="vote" onclick="location='VotePageServlet?id=${vote.id}&votename=${vote.name}'">
                        <td>${vote.id}</td>
                        <td>${vote.title}</td>
                        <td>${vote.name}</td>
                        <td>${vote.count}</td>
                        <td>${vote.date}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5" align="center">当前没有正在进行的投票</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>
</div>