package com.lzqedu.bookCity.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.lzqedu.bookCity.dao.OrderBeanDAO;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.User;

import java.util.List;

public class OrderBeanDAOImpl extends BaseDAO<OrderBean> implements OrderBeanDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        executeUpdate("insert into t_order values(null,?,?,?,?,0)",orderBean.getOrderNo(),orderBean.getOrderDate(),
                orderBean.getOrderUser().getId(),orderBean.getOrderMoney());
    }

    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        return executeQuery("select * from t_order where orderUser = ?",user.getId());
    }

    @Override
    public OrderBean getOrderBean(String orderNo) {
        return load("select * from t_order where orderNo = ?",orderNo);
    }
}
