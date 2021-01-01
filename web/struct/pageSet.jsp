<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<form action="SearchVoteListServlet" method="get">
    <div class="input-group pageset">
        <span class="input-group-btn">
            <button class="btn btn-info" type="button" onclick="location='PageReduce'">上一页</button>
        </span>
        <input type="text" class="form-control" style="height: 33px;margin-left: 7px;" name="content" id="num" value="${requestScope.num}/${requestScope.maxNum}" disabled="disabled">
        <span class="input-group-btn">
            <button class="btn btn-info" type="button" onclick="location='PageAdd'">下一页</button>
        </span>
    </div>
</form>