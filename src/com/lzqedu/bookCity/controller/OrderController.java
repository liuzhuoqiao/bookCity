package com.lzqedu.bookCity.controller;

import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.OrderBeanService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderController {
    OrderBeanService orderBeanService;
    public String index(HttpSession session){
        User user=(User)session.getAttribute("user");
        List<OrderBean> orderBeanList = orderBeanService.getOrderBeanList(user);
        session.setAttribute("orderBeanList",orderBeanList);
        return "order/order";
    }
}
