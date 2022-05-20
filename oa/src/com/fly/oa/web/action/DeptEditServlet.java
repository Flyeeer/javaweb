package com.fly.oa.web.action;

import com.fly.oa.domain.DeptTable;
import com.fly.oa.service.DeptService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Fly
 * @Vision 1.0
 */

public class DeptEditServlet extends HttpServlet {
    private DeptService deptService = new DeptService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        DeptTable deptTable = deptService.selectByDeptno(deptno);

        out.print("<!DOCTYPE html>");
        out.print("<html lang='zn-CN'>");
        out.print("<head>");
        out.print("    <meta charset='UTF-8'>");
        out.print("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("    <title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <h1>修改部门</h1>");
        out.print("    <hr>");
        out.print("    <form action='/oa/dept/modify' method='post'>");
        out.print("                部门编号<input type='text' name='deptno' value='"+deptTable.getDeptNo()+"' readonly><br>");
        out.print("                部门名称<input type='text' name='dname' value='"+deptTable.getdName()+"'><br>");
        out.print("                部门位置<input type='text' name='loc' value='"+deptTable.getLoc()+"'><br>");
        out.print("        <input type='submit' value='修改'><br>");
        out.print("    </form>");
        out.print("</body>");
        out.print("</html>");
    }
}
