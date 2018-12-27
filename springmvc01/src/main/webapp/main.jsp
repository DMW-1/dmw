<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ include file=""%>--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .left{
            float: left;
        }

        .clearfix::after{
            content: '.';
            height: 0;
            display: block;
            visibility: hidden;
            clear: both;
        }

    </style>
</head>
<body>
    <div>
        卡号：${account.cardNo} <a href="${ctx}/account/logout">退出登录</a>
    </div>
    <div class="clearfix">
        <div class="left">
            <div><a href="${ctx}/account/balance/${account.cardNo}">查询余额</a></div>
            <div><a href="${ctx}/account/transferTo">转账</a></div>
            <div><a href="${ctx}/transactionRecord/index">查询交易记录</a></div>
            <div><a href="">修改密码</a></div>
        </div>
        <div class="left">
            <c:if test="${page eq 'balance'}">
                <%--引入balance页面--%>
                <jsp:include page="${ctx}/balance.jsp" />
            </c:if>
            <c:if test="${page eq 'transfer'}">
                <%--引入balance页面--%>
                <jsp:include page="${ctx}/transfer.jsp" />
            </c:if>
            <c:if test="${page eq 'record'}">
                <%--引入balance页面--%>
                <jsp:include page="${ctx}/record.jsp" />
            </c:if>
        </div>
    </div>
</body>
</html>
