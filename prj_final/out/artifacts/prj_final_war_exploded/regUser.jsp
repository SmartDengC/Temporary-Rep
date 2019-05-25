<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/24
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="cn.dc.dao.userDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>title</title>
</head>
<body>
<jsp:useBean id="user" class="cn.dc.bean.users" type="cn.dc.bean.users" />
<%
    // 就是把reg.jsp中的数据存到数据库中
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String age = request.getParameter("age");
    String sex = request.getParameter("radio");
    String hobby = request.getParameter("checkbox");
%>
<jsp:setProperty name="user" property="*" />

<%
    userDao dao = new userDao();
    boolean x = dao.addUser(user);
    if (x){
        out.print("<script>alert("+"Add User Succeed!"+")</script>");
    }
    else {
        out.print("<script>alert("+"Add User Error!"+")</script>");
    }
%>


</body>
</html>
