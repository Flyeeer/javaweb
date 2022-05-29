<%@ page import="java.util.List" %>
<%@ page import="com.fly.oa.domain.DeptTable" %>
<%@page contentType="text/html; charset=UTF-8" %>
 <!DOCTYPE html>
 <html lang='zn-CN'>
 <head>
     <meta charset='UTF-8'>
     <meta http-equiv='X-UA-Compatible' content='IE=edge'>
     <meta name='viewport' content='width=device-width, initial-scale=1.0'>
     <title>部门列表</title>

 <script type='text/javascript'>
         function del(dno) {
     if(window.confirm('宝, 你确定删除吗？')) {
         document.location.href = '<%=request.getContextPath()%>/dept/delete?deptno=' + dno;
     }
 }
 </script>

 </head>
 <body>
     <h3>欢迎 <%=session.getAttribute("username")%></h3>
     <a href="<%=request.getContextPath()%>/user/exit">退出登录</a>
     <h1 align='center'>部门列表</h1>
     <hr>
     <table border='1px' align='center' width='50%'>
             <tr>
                     <th>序号</th>
                     <th>部门编号</th>
                     <th>部门名称</th>
                     <th>操作</th>
                 </tr>

            <% int i = 0;
                List<DeptTable> deptTableList = (List<DeptTable>)request.getAttribute("deptTableList");
                for (DeptTable deptTable : deptTableList) {

            %>
                <tr>
                     <td><%=++i%></td>
                     <td><%=deptTable.getDeptNo()%></td>
                     <td><%=deptTable.getdName()%></td>
                     <td>
                          <a href='javascript:void(0)' onclick='del(<%=deptTable.getDeptNo()%>)'>删除</a>
                          <a href='<%=request.getContextPath()%>/dept/detail?f=edit&deptno=<%=deptTable.getDeptNo()%>'>修改</a>
                          <a href='<%=request.getContextPath()%>/dept/detail?f=detail&deptno=<%=deptTable.getDeptNo()%>'>详情</a>
                     <td>
                 </tr>
            <%}%>


         </table>
     <a href='<%=request.getContextPath()%>/add.jsp'>新增部门</a>
 </body>
 </html>

