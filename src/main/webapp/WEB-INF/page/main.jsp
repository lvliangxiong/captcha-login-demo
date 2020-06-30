<%--
  User: Joey
  Date: 20/03/2020
  Time: 11:39 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>MAIN</title>
    <base href="<%=basePath%>">
</head>
<body>
欢迎登录：${user.username}
</body>
</html>