package com.lzqedu.bookCity.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.lzqedu.bookCity.dao.CartItemDAO;
import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.User;

import java.util.List;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean = ?",user.getId());
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart_item values(null,?,?,?)",cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        executeUpdate("delete from t_cart_item where id=?",cartItem.getId());
    }

    @Override
    public void editCartItem(CartItem cartItem) {
        executeUpdate("update t_cart_item set buyCount=? where id=?", cartItem.getBuyCount(), cartItem.getId());
    }

    @Override
    public CartItem getCartItem(Book book,User user) {
        return load("select * from t_cart_item where book = ? and userBean = ?",book.getId(),user.getId());
    }

    @Override
    public void cleanCart(User user) {
        executeUpdate("delete from t_cart_item where userBean=? ",user.getId());
    }
}
