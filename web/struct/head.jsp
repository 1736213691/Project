<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<header class="header">
    <div class="title2">
        <span id="id" class="title3">${sessionScope.userName}</span><span class="title3">，您好！</span>
    </div>
    <div class="title vote" onclick="location='/ov/IndexServlet'"><span>网上投票系统</span></div>
    <div class="title2" style="color: black; text-shadow: none">
        <span class="title3"><a href="/ov/applicat/addVote.jsp">发布投票</a></span>
        <div class="dropdown" style="margin-left: 10px;">
            <button type="button" class="btn btn-info dropdown-toggle" id="dropdownMenu1"
                    data-toggle="dropdown">
                个人中心
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="MyIndexServlet">我发布的投票</a>
                </li>
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" data-toggle="modal" data-target="#myModal">修改密码</a>
                </li>
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="/ov/loginOut.jsp">安全登出</a>
                </li>
            </ul>
        </div></div>
</header>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="max-width: 600px;margin-top: 20vh;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">
                    密码修改
                </h4>
            </div>
            <div class="modal-body" style="min-height: 300px;">
                <table style="width: 300px;min-height: 300px;margin-left: 150px;">
                    <tr><td>原 密 码 ：</td><td><input id="before" type="password" style="border-radius: 2px"></td></tr>
                    <tr><td>密    码 ：</td><td><input id="update" type="password" style="border-radius: 2px"></td></tr>
                    <tr><td>确认密码 ：</td><td><input id="update2" type="password" style="border-radius: 2px"></td></tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" onclick="return updatePass()">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>