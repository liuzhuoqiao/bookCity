package com.lzqedu.bookCity.service;

import com.lzqedu.bookCity.pojo.User;

public interface UserService {
    User login(String uname,String pwd);
    void addUser(User user);
}
