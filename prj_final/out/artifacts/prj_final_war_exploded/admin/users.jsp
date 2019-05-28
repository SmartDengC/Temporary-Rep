<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/22
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="cn.dc.bean.users" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>userList</title>
    <script>
        var result = <%=request.getAttribute("result")%>;
        alert(result)
        if (result != null){
            alert(decodeURIComponent(result));
            window.location.href='login.jsp';
        }
    </script>
</head>
<body>
<jsp:useBean id="User" class="cn.dc.bean.users" />
<table align="center" width="450" border="1">
    <tr>
        <td align="center" colspan="6">
            <h2>用户信息展示</h2>
        </td>
    </tr>
    <tr align="center">
        <td>ID</td>
        <td>姓名</td>
        <td>密码</td>
        <td>年龄</td>
        <td>爱好</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${requestScope.usersList}" var="item" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${item.name}</td>
            <td>${item.password}</td>
            <td>${item.age}</td>
            <td>${item.hobby}</td>
            <td>
                <a href='/prj_final/admin/updateUser?id=${item.id }'>修改</a>
                <a href='/prj_final/admin/deleteUser?id=${item.id }'>删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" colspan="5">
            <%=request.getAttribute("bar")%>
        </td>
    </tr>
</table>
</body>
</html>
