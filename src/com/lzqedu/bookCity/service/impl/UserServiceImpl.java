package com.lzqedu.bookCity.service.impl;

import com.lzqedu.bookCity.dao.UserDAO;
import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.UserService;

public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
