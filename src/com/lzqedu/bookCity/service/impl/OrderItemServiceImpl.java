package com.lzqedu.bookCity.service.impl;

import com.lzqedu.bookCity.dao.OrderItemDAO;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.OrderItem;
import com.lzqedu.bookCity.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDAO orderItemDAO;
    @Override
    public List<OrderItem> getOrderItemList(OrderBean orderBean) {
        return orderItemDAO.getOrderItemList(orderBean);
    }

    @Override
    public void addOrderItem(CartItem cartItem,OrderBean orderBean) {
        orderItemDAO.addOrderItem(cartItem,orderBean);
    }
}
