package com.lzqedu.bookCity.service;

import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.User;

import java.util.List;

public interface OrderBeanService {
    List<OrderBean> getOrderBeanList(User user);
    void addOrderBean(User user);

}
