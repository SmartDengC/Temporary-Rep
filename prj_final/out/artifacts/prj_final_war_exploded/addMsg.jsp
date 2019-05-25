<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/24
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.dc.dao.messageDao" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="message" class="cn.dc.bean.message" />
<%
    //处理 leaveMsg.jsp 中的数据
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    // Time is what?
%>
<jsp:setProperty name="message" property="*" />
<%
    messageDao dao = new messageDao();
    dao.addMessage(message);
%>
</body>
</html>
