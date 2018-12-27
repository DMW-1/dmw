<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #main{
            width: 80%;
            margin: auto;
            /*background-color: green;*/
        }
        form{
            margin: auto;
            width: 30%;
        }
    </style>
</head>
<body>

    <div id="main">
        <form action="${ctx}/account/login" method="post" onsubmit="return check()">
            <h1>个人网上银行</h1>
            卡号： <input type="text" name="cardNo"> <br>
            密码： <input type="password" name="password"> <br>
            <input type="submit" value="登录网上银行">
        </form>
    </div>

    <script src="${ctx}/static/jquery/jquery.js">

    </script>
<script>
    var errorMsg = '${errorMsg}';
    if(errorMsg != null && errorMsg != undefined && errorMsg != ''){
        alert(errorMsg);
    }
    
    function  check() {
       var cardNo =  $('input[name=cardNo]').val();
       if(cardNo.length != 16){
           alert("卡号长度必须为16位");
           return false;
       }
       var pwd = $('input[type=password]').val();
       if(pwd.length != 6){
           alert("密码长度必须为6位");
           return false;
       }
       return true;
    }

</script>
</body>
</html>
