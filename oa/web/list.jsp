<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
         document.location.href = '${pageContext.request.contextPath}/dept/delete?deptno=' + dno;
     }
 }
 </script>

 </head>
 <body>
     <h3>欢迎 ${username}</h3>
     <a href="${pageContext.request.contextPath}/user/exit">退出登录</a>
     <h1 align='center'>部门列表</h1>
     <hr>
     <table border='1px' align='center' width='50%'>
             <tr>
                     <th>序号</th>
                     <th>部门编号</th>
                     <th>部门名称</th>
                     <th>操作</th>
                 </tr>

         <c:forEach items="${deptTableList}" varStatus="deptStatus" var="deptTable">
             <tr>
                 <td>${deptStatus.count}</td>
                 <td>${deptTable.deptNo}</td>
                 <td>${deptTable.dName}</td>
                 <td>
                     <a href='javascript:void(0)' onclick='del(${deptTable.deptNo})'>删除</a>
                     <a href='${pageContext.request.contextPath}/dept/detail?f=edit&deptno=${deptTable.deptNo}'>修改</a>
                     <a href='${pageContext.request.contextPath}/dept/detail?f=detail&deptno=${deptTable.deptNo}'>详情</a>
                 <td>
             </tr>
         </c:forEach>
         </table>
     <a href='${pageContext.request.contextPath}/add.jsp'>新增部门</a>
 </body>
 </html>

