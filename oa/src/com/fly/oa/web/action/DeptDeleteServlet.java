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

public class DeptDeleteServlet extends HttpServlet {
    private DeptService deptService = new DeptService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");

        int update = deptService.deleteByDeptno(deptno);
        if(update == 1){
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else{
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
