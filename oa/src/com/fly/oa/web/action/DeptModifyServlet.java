package com.fly.oa.web.action;

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

public class DeptModifyServlet extends HttpServlet {
    private DeptService deptService = new DeptService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        int update = deptService.update(deptno, dname, loc);

        if(update == 1){
            //修改成功
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }{
            //修改失败
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
