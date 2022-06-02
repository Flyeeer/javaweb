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
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("username".equals(name)){
                    username = cookie.getValue();
                } else if ("password".equals(name)) {
                    password = cookie.getValue();
                }
            }

        }
        if (username != null && password != null) {
            User user = userService.selectByUnameAndPwd(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/dept/list");
            }else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
