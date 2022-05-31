<%--
  Created by IntelliJ IDEA.
  User: 辉煌
  Date: 2022/5/25
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>

<body>
<h1>Author:<span style="color: red">2020211001001208-Luhuihuang</span></h1>
<h2>Welcome,
    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
    <jsp:useBean id="user" class="com.Luhuihuang.Lab2.Login" scope="request"></jsp:useBean>
    <%--todo 10 : use jsp:getProperty to display username --%>
    <jsp:getProperty name="user" property="username"/>

</h2>
</body>
</html>
