package com.fly.oa.web.action;

import com.fly.oa.domain.User;
import com.fly.oa.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Fly
 * @Vision 1.0
 */
@WebServlet("/user/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.selectByUnameAndPwd(username, password);
        if (user != null) {
            response.sendRedirect(request.getContextPath()+ "/dept/list");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
