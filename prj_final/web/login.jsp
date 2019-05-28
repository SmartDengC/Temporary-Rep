<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/21
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>LOGIN</title>
    <style type="text/css">
      .divForm{
        position: absolute;
        width: 300px;
        height: 200px;
        /*border: 1px solid red;*/
        text-align: left;/*(让div中的内容居中)*/
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -150px;
      }
    </style>
  </head>
  <body>
  <div class="divForm">
      <form action="login" method="POST">
        用  户：<input type="text" name="username"> <br>
        密  码：<input type="password" name="password"> <br>
        验证码：<input type="text" name="checkin">
        <img src="<%=request.getContextPath()%>/ValidateServlet" alt="picture"> <br>
        <input type="checkbox" checked="checked" name="choice">自动登录 <br>
        <input type="submit"> <a href="<%=request.getContextPath()%>/reg.jsp">注册</a>
      </form>
  </div>

  </body>
</html>
