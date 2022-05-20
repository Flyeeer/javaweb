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

public class DeptDetailServlet extends HttpServlet {
    private DeptService deptService = new DeptService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();

        DeptTable deptTable = deptService.selectByDeptno(deptno);

        if (deptTable != null) {
            out.print("<!DOCTYPE html>");
            out.print("<html lang='zn-CN'>");
            out.print("<head>");
            out.print("    <meta charset='UTF-8'>");
            out.print("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("    <title>部门详情</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("    <h1>部门详情</h1>");
            out.print("    <hr>");


            out.print("                部门编号： "+deptTable.getDeptNo()+"<br>");
            out.print("                部门名称： "+deptTable.getdName()+"<br>");
            out.print("        部门位置； "+deptTable.getLoc()+"<br>");


            out.print("    <input type='button' value='返回' onclick='window.history.back()'>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}
