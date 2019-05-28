<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/5/23
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 添加用户 --%>
<form action="addUser" method="post"><br>
    用户:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    年龄:<input type="number" name="age"><br>
    性别:<input type="text" name="sex"><br>
    爱好:<input type="text" name="hobby"><br>
    <input type="submit"><br>
</form>

</body>
</html>
