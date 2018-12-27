<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:if test="${ not empty code and not  empty msg}">
    <c:if test="${code eq 2020}">
        <h2>操作已成功</h2>
    </c:if>
    <c:if test="${code != 2020}">
        <script>
            alert('${msg}');
        </script>
    </c:if>
</c:if>


<c:if test="${ empty code and empty msg}">
    <h2>当前操作是转账</h2>

    <form action="${ctx}/account/transfer" method="post">
        转入账号： <input type="text" name="cardNo"> <br>
        转入金额： <input type="text" name="transactionAmount"> <br>
        <input type="submit" value="转账">
    </form>

</c:if>

