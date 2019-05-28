<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/24
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
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
        <form action="regUser.jsp" method="post"><br>
            用户:<input type="text" name="username"><br>
            密码:<input type="password" name="password"><br>
            年龄:<input type="number" name="age"><br>
            性别:
            <input type="radio" name="radio" checked="checked">Man
            <input type="radio" name="radio">Woman<br>
            爱好: <br>
            <input type="checkbox" name="checkbox" value="Basketball">Basketball<br>
            <input type="checkbox" name="checkbox" value="Football">Football<br>
            <input type="checkbox" name="checkbox" value="Ping Pong">Ping Pong<br>
            <input type="submit"><br>
        </form>
    </div>

</body>
</html>
