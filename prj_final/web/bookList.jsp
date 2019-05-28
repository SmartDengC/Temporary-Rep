<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/24
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>bookList</title>
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
<jsp:useBean id="Book" class="cn.dc.bean.books" />
<table align="center" width="450" border="1">
    <tr>
        <td align="center" colspan="6">
            <h2>用户信息展示</h2>
        </td>
    </tr>
    <tr align="center">
        <td>ID</td>
        <td>BookId</td>
        <td>Name</td>
        <td>Author</td>
        <td>Publicer</td>
        <td>Price</td>
    </tr>

    <c:forEach items="${requestScope.booksList}" var="item" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${item.bookId}</td>
            <td>${item.name}</td>
            <td>${item.author}</td>
            <td>${item.publicer}</td>
            <td>${item.price}</td>
            <td>
                <a href='/prj_final/admin/deleteUser?id=${item.id }'>添加到购物车</a>
                <a href='/prj_final/cart.jsp}'>购物车</a>
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

