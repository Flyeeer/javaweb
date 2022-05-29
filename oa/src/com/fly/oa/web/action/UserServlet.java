package com.fly.oa.web.action;

import com.fly.oa.domain.User;
import com.fly.oa.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @author Fly
 * @Vision 1.0
 */
@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/user/login".equals(servletPath)){
            doLogin(request,response);
        }else if("/user/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            response.sendRedirect(request.getContextPath() );
        }
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.selectByUnameAndPwd(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            if ("1".equals(request.getParameter("f"))){
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("password", password);
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie1.setPath(request.getContextPath());

                cookie2.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setPath(request.getContextPath());
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            response.sendRedirect(request.getContextPath()+ "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
