<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zn-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎来到oa系统</title>
</head>

<body>
    <h1>用户登录</h1>
    <hr>
    <form action="<%=request.getContextPath()%>/user/login" method="post" >
          用户名: <input type="text" name="username">
          <br>
          密码: <input type="password" name="password">
          <input type="submit" value="登录"> <br>
          <input type="checkbox" name="f" value="1">十天内免登录
    </form>

</body>

</html>