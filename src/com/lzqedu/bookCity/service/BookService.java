package com.lzqedu.bookCity.service;

import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.Cart;
import com.lzqedu.bookCity.pojo.CartItem;

import java.util.List;

public interface BookService {

    List<Book> getBookList();
    Book getBook(Integer id);

}
