package com.lzqedu.bookCity.controller;

import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.BookService;
import com.lzqedu.bookCity.service.CartItemService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    BookService bookService;
    CartItemService cartItemService;
    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);
        User user = (User)session.getAttribute("user");
        int cartItemNum = cartItemService.getCartItemNum(user);
        session.setAttribute("cartItemNum",cartItemNum);
        return "index";
    }
}
