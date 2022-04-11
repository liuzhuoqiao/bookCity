package com.lzqedu.bookCity.service;

import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.Cart;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.User;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItemList(User user);
    int getCartItemNum(User user);
    void addNewCartItem(CartItem cartItem);
    void addCartItem(CartItem cartItem);
    void delCartItem(CartItem cartItem);
    void editCartItem(CartItem cartItem);
    CartItem getCartItem(Book book,User user);
    void cleanCart(User user);
    int totalNumberOfItems(User user);
    double totalAmount(User user);
}
