package com.lzqedu.bookCity.dao;

import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.User;

import java.util.List;

public interface CartItemDAO {
    List<CartItem> getCartItemList(User user);
    void addCartItem(CartItem cartItem);
    void delCartItem(CartItem cartItem);
    void editCartItem(CartItem cartItem);
    CartItem getCartItem(Book book,User user);
    void cleanCart(User user);
}
