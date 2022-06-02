package com.fly.oa.domain;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.util.Objects;

/**
 * @author Fly
 * @Vision 1.0
 */

public class User implements HttpSessionBindingListener {
    private int id;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        Integer onlineCount = (Integer) application.getAttribute("onlineUser");
        if (onlineCount == null) {
            application.setAttribute("onlineUser", 1);
        } else {
            int count =  (Integer) application.getAttribute("onlineUser");
            count++;
            application.setAttribute("onlineUser", count);
        }
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        Integer onlineCount = (Integer) application.getAttribute("onlineUser");
        onlineCount--;
        application.setAttribute("onlineUser", onlineCount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
}
