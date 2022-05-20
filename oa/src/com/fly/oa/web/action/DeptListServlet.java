package com.fly.oa.web.action;

import com.fly.oa.domain.DeptTable;
import com.fly.oa.service.DeptService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Fly
 * @Vision 1.0
 */

public class DeptListServlet extends HttpServlet {
    private DeptService deptService = new DeptService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();

        List<DeptTable> deptTableList = deptService.list();
        for (DeptTable deptTable : deptTableList) {
            System.out.println(deptTable);
        }

        out.print("<!DOCTYPE html>");
        out.print("<html lang='zn-CN'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>部门列表</title>");

        out.print("<script type='text/javascript'>");
        out.print("        function del(dno) {");
        out.print("    if(window.confirm('宝, 你确定删除吗？')) {");
        out.print("        document.location.href = '"+contextPath+"/dept/delete?deptno=' + dno;");
        out.print("    }");
        out.print("}");
        out.print("</script>");

        out.print("</head>");
        out.print("<body>");
        out.print("    <h1 align='center'>部门列表</h1>");
        out.print("    <hr>");
        out.print("    <table border='1px' align='center' width='50%'>");
        out.print("        <tr>");
        out.print("            <th>序号</th>");
        out.print("            <th>部门编号</th>");
        out.print("            <th>部门名称</th>");
        out.print("            <th>操作</th>");
        out.print("        </tr>");
        //上面都是写死的页面
        int i = 0;
        for (DeptTable table : deptTableList) {
            out.print("        <tr>");
            out.print("            <td>" + (++i) + "</td>");
            out.print("            <td>" + table.getDeptNo() + "</td>");
            out.print("            <td>" + table.getdName() + "</td>");
            out.print("            <td>");
            out.print("                 <a href='javascript:void(0)' onclick='del("+table.getDeptNo()+")'>删除</a>");
            out.print("                 <a href='"+contextPath+"/dept/edit?deptno="+table.getDeptNo()+"'>修改</a>");
            out.print("                 <a href='"+contextPath+"/dept/detail?deptno="+table.getDeptNo()+"'>详情</a>");
            out.print("            <td>");
            out.print("        </tr>");
        }


        out.print("    </table>");
        out.print("    <a href='"+contextPath+"/add.html'>新增部门</a>");
        out.print("</body>");
        out.print("</html>");
    }
}
