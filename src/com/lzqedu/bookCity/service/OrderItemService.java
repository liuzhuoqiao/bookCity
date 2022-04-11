package com.lzqedu.bookCity.service;

import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemList(OrderBean orderBean);
    void addOrderItem(CartItem cartItem,OrderBean orderBean);
}
