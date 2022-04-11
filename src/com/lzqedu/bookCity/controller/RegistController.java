package com.lzqedu.bookCity.controller;

import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.UserService;

public class RegistController {
    UserService userService;
    public String index(){

        return "user/regist";
    }
    public String registerAnAccount(String username,String pwd,String email){
        User user = new User(username, pwd, email, 0);
        userService.addUser(user);
        return "user/login";
    }
}
