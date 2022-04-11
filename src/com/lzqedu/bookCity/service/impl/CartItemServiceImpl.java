package com.lzqedu.bookCity.service.impl;

import com.lzqedu.bookCity.dao.CartItemDAO;
import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.BookService;
import com.lzqedu.bookCity.service.CartItemService;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {
    CartItemDAO cartItemDAO;
    BookService bookService;

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for (int i = 0; i < cartItemList.size(); i++) {
            CartItem cartItem = cartItemList.get(i);
            Book book = cartItem.getBook();
            book = bookService.getBook(book.getId());
            cartItem.setBook(book);
        }
        return cartItemList;
    }

    @Override
    public int getCartItemNum(User user) {
        return getCartItemList(user).size();
    }

    @Override
    public void addNewCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        CartItem sqlCartItem = getCartItem(cartItem.getBook(), cartItem.getUserBean());
        if (sqlCartItem != null) {
            Integer buyCount = sqlCartItem.getBuyCount();
            sqlCartItem.setBuyCount(++buyCount);
            editCartItem(sqlCartItem);
        } else {
            addNewCartItem(cartItem);
        }
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        cartItemDAO.delCartItem(cartItem);
    }

    @Override
    public void editCartItem(CartItem cartItem) {
        if (cartItem.getBuyCount() <= 0) {
            cartItemDAO.delCartItem(cartItem);
        } else {
            cartItemDAO.editCartItem(cartItem);
        }

    }

    @Override
    public CartItem getCartItem(Book book, User user) {
        return cartItemDAO.getCartItem(book, user);
    }

    @Override
    public void cleanCart(User user) {
        cartItemDAO.cleanCart(user);
    }

    @Override
    public int totalNumberOfItems(User user) {
        List<CartItem> cartItemList = getCartItemList(user);
        int count = 0;
        for (int i = 0; i < cartItemList.size(); i++) {
            count += cartItemList.get(i).getBuyCount();
        }
        return count;
    }

    @Override
    public double totalAmount(User user) {
        double count = 0;
        List<CartItem> cartItemList = getCartItemList(user);
        for (int i = 0; i < cartItemList.size(); i++) {
            count += cartItemList.get(i).getBuyCount() * cartItemList.get(i).getBook().getBookCount();
        }
        return count;
    }
}
