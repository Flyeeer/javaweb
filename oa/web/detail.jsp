<%@ page import="com.fly.oa.domain.DeptTable" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zn-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>部门详情</title>
</head>
<body>
    <h1>部门详情</h1>
    <hr>

    <%
            DeptTable deptTable = (DeptTable)request.getAttribute("deptTable");
    %>
    部门编号： <%=deptTable.getDeptNo()%><br>
    部门名称： <%=deptTable.getdName()%><br>
    部门位置； <%=deptTable.getLoc()%><br>
    <input type="button" value="返回" onclick="window.history.back()">
</body>
</html>