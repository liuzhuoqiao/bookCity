package com.lzqedu.bookCity.dao;

import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.User;

import java.util.List;

public interface OrderBeanDAO {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderBeanList(User user);
    OrderBean getOrderBean(String  orderNo);
}
