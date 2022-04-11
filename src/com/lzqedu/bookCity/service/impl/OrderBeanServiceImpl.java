package com.lzqedu.bookCity.service.impl;

import com.lzqedu.bookCity.dao.OrderBeanDAO;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.OrderItem;
import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.CartItemService;
import com.lzqedu.bookCity.service.OrderBeanService;
import com.lzqedu.bookCity.service.OrderItemService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderBeanServiceImpl implements OrderBeanService {
    OrderBeanDAO orderBeanDAO;
    OrderItemService orderItemService;
    CartItemService cartItemService;
    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        List<OrderBean> orderBeanList = orderBeanDAO.getOrderBeanList(user);
        for (int i = 0; i < orderBeanList.size(); i++) {
            List<OrderItem> orderItemList = orderItemService.getOrderItemList(orderBeanList.get(i));
            orderBeanList.get(i).setOrderItemList(orderItemList);
        }
        return orderBeanList;
    }

    @Override
    public void addOrderBean(User user) {
        long time=new Date().getTime();
        Date dates=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        String times=sdf.format(dates);
        String orderNo ="12354456895" + "_" + times;
        double orderMoney = cartItemService.totalAmount(user);
        OrderBean orderBean = new OrderBean(orderNo, dates, user, orderMoney);
        orderBeanDAO.addOrderBean(orderBean);
        orderBean = orderBeanDAO.getOrderBean(orderNo);
        List<CartItem> cartItemList = cartItemService.getCartItemList(user);
        for (int i = 0; i < cartItemList.size(); i++) {
            orderItemService.addOrderItem(cartItemList.get(i),orderBean);
        }
    }
}
