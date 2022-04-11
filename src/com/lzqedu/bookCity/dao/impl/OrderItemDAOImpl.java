package com.lzqedu.bookCity.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.lzqedu.bookCity.dao.OrderItemDAO;
import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.OrderItem;

import java.util.List;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(CartItem cartItem,OrderBean orderBean) {
        executeUpdate("insert into t_order_item values(null,?,?,?)",cartItem.getBook().getId(),cartItem.getBuyCount(),orderBean.getId());
    }

    @Override
    public List<OrderItem> getOrderItemList(OrderBean orderBean) {
        return executeQuery("Select * from t_order_item where orderBean = ?",orderBean.getId());
    }
}
