package com.fly.oa.web.action;

import com.fly.oa.domain.DeptTable;
import com.fly.oa.service.DeptService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Fly
 * @Vision 1.0
 */

@WebServlet({"/dept/list", "/dept/detail", "/dept/delete", "/dept/save", "/dept/modify"})
public class DeptServlet extends HttpServlet {
    private DeptService deptService = new DeptService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
//        HttpSession session = request.getSession(false);
//        if(session != null && session.getAttribute("username") != null){
//            if("/dept/list".equals(servletPath)){
//                doList(request,response);
//            } else if ("/dept/detail".equals(servletPath)) {
//                doDetail(request,response);
//            } else if("/dept/delete".equals(servletPath)){
//                doDelete(request,response);
//            } else if ("/dept/save".equals(servletPath)) {
//                doSave(request,response);
//            } else if("/dept/modify".equals(servletPath)){
//                doModify(request,response);
//            }
//        } else {
//            response.sendRedirect(request.getContextPath() + "/index.jsp");
//        }
        if("/dept/list".equals(servletPath)){
            doList(request,response);
        } else if ("/dept/detail".equals(servletPath)) {
            doDetail(request,response);
        } else if("/dept/delete".equals(servletPath)){
            doDelete(request,response);
        } else if ("/dept/save".equals(servletPath)) {
            doSave(request,response);
        } else if("/dept/modify".equals(servletPath)){
            doModify(request,response);
        }

    }

    private void doModify(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setCharacterEncoding("UTF-8");
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        int update = deptService.update(deptno, dname, loc);

        if(update == 1){
            response.sendRedirect(contextPath + "/dept/list");
        }else{
            //修改失败
            response.sendRedirect(contextPath+ "/error.jsp");
        }
    }

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        int update = deptService.add(deptno, dname, loc);
        if(update == 1){
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(contextPath + "/dept/list");
        }else{
            //request.getRequestDispatcher("/error.jsp").forward(request,response);
            response.sendRedirect(contextPath + "/error.jsp");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        DeptTable deptTable = deptService.selectByDeptno(deptno);
        request.setAttribute("deptTable", deptTable);
        request.getRequestDispatcher("/"+ request.getParameter("f" )+ ".jsp").forward(request,response);
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<DeptTable> deptTableList = deptService.list();

        request.setAttribute("deptTableList", deptTableList);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptno = request.getParameter("deptno");

        int update = deptService.deleteByDeptno(deptno);
        if(update == 1){
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/dept/list");
            System.out.println("删除了一条记录");
        }else{
            //request.getRequestDispatcher("/error.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}

