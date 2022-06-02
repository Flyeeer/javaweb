package com.fly.oa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author Fly
 * @Vision 1.0
 */

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);

        if("/index.jsp".equals(servletPath) || "/welcome".equals(servletPath) ||
                "/user/login".equals(servletPath) || "/user/exit".equals(servletPath) ||
                session != null && session.getAttribute("user") != null){

            chain.doFilter(request,response);
        } else {
            System.out.println("过滤一下");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
