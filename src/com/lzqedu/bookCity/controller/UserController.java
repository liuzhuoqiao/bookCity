package com.lzqedu.bookCity.controller;

import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.CartItemService;
import com.lzqedu.bookCity.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {
    UserService userService;
    CartItemService cartItemService;
    public String login(String uname, String pwd, HttpSession session){
        User user = userService.login(uname, pwd);
        if (user != null){
            session.setAttribute("user",user);
            return "redirect:book.do";
        }else {
            return "user/login";
        }
    }
    public String logOut(HttpSession session){
        User user = null;
        session.setAttribute("user",user);
        return "user/login";
    }
}
