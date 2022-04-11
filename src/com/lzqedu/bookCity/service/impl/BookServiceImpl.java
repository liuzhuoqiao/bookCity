package com.lzqedu.bookCity.service.impl;

import com.lzqedu.bookCity.dao.BookDAO;
import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDAO bookDAO;
    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
