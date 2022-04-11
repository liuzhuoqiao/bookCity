package com.lzqedu.bookCity.dao;

import com.lzqedu.bookCity.pojo.User;

public interface UserDAO {
    User getUser(String uname,String pwd);
    void addUser(User user);
}
