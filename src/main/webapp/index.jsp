<%--
  User: Joey
  Date: 6/20/2020
  Time: 4:41 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Login</title>
    <base href="<%= basePath %>">
    <script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".captcha_refresh").click(function () {
                // 由于浏览器的缓存功能，浏览器不会取请求相同URL的资源
                // 可以添加一个无意义的时间戳
                $("img").attr("src", "captcha?date=" + new Date());
            });
        });
    </script>
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
<div class="login-form">
    <form action="loginCheck" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td>
                    <input type="text" name="username" value=""/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <input type="password" name="password" value=""/>
                </td>
                <td>
                    <span class="error-info">
                        <c:if test="${errorInfo == 1}">
                            用户名或密码不正确
                        </c:if>
                    </span>
                </td>
            </tr>
            <tr>
                <td>Captcha:</td>
                <td>
                    <input type="text" name="captcha" value=""/>

                </td>
                <td>
                    <span class="error-info">
                      <c:if test="${errorInfo == 2}">
                          验证码错误
                      </c:if>
                    </span>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="button" class="captcha_refresh">看不清</button>
                </td>
                <td>
                    <img src="captcha" width="150"/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <button type="reset">重置</button>
                </td>
                <td align="right">
                    <button type="submit">提交</button>
                </td>
                <td></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>