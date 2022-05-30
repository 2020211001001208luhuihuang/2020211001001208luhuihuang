<%--
  Created by IntelliJ IDEA.
  User: 辉煌
  Date: 2022/5/25
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <title>Title</title>
</head>
<body>
<br>
<%@include file="header.jsp"%>
<h1>Login</h1>
<form action="<%=request.getContextPath()%>/login" method="post">
    UserName:<input type="text" name="username"> <br>
    Password:<input type="password" name="password"> <br>
    <input type="submit" value="Login">
        <%
    if(request.getAttribute("message")==null){
        out.println("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
    <form method="post" action="/2020211001001208Luhuihuang_war_exploded/login">
        Username:<input type="text" name="username" ><br/>
        Password:<input type="password" name="password"><br/>
        <input type="submit" value="Login"/>
    </form>
    <%@ include file="footer.jsp"%>
</body>
</html>

<%@include file="footer.jsp"%>
</html>
