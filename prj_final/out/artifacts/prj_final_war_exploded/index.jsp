<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/24
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<div class="divForm">
    <a href="<%=request.getContextPath()%>/leaveMsg.jsp">Add Message</a>
    <a href="<%=request.getContextPath()%>/guestBook.jsp">Point Guest Book</a>
</div>
<body>

</body>
</html>
