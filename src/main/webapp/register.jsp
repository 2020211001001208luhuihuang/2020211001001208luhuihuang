<%--
  Created by IntelliJ IDEA.
  User: 辉煌
  Date: 2022/3/16
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="register">
    Username<input type="text" name="username"/><br/>
    Password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth:<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
