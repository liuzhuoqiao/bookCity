package com.lzqedu.bookCity.dao;

import com.lzqedu.bookCity.pojo.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBookList();
    Book getBook(Integer id);
}
