package com.fly.oa.service;

import com.fly.oa.dao.UserDAO;
import com.fly.oa.domain.User;

/**
 * @author Fly
 * @Vision 1.0
 */

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User selectByUnameAndPwd(String username, String password){
        String sql = "select username, password from t_user where username = ? and password = ?";
        return userDAO.querySingle(sql, User.class, username, password);
    }
}
