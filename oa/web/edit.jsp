<%@ page import="com.fly.oa.domain.DeptTable" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    DeptTable deptTable = (DeptTable)request.getAttribute("deptTable");
%>
<!DOCTYPE html>
<html lang='zn-CN'>
<head>
    <meta charset='UTF-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>修改部门</title>
</head>
<body>
    <h3>欢迎 <%=session.getAttribute("username")%></h3>
    <h1>修改部门</h1>
    <hr>
    <form action='<%=request.getContextPath()%>/dept/modify' method='post'>
        部门编号<input type='text' name='deptno' value='<%=deptTable.getDeptNo()%>' readonly><br>
        部门名称<input type='text' name='dname' value='<%=deptTable.getdName()%>'><br>
        部门位置<input type='text' name='loc' value='<%=deptTable.getLoc()%>'><br>
        <input type='submit' value='修改'><br>
    </form>
</body>
</html>