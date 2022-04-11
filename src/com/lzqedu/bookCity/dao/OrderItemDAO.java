package com.lzqedu.bookCity.dao;

import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    void addOrderItem(CartItem cartItem,OrderBean orderBean);
    List<OrderItem> getOrderItemList(OrderBean orderBean);
}
