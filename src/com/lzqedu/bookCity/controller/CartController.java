package com.lzqedu.bookCity.controller;

import com.lzqedu.bookCity.pojo.Book;
import com.lzqedu.bookCity.pojo.CartItem;
import com.lzqedu.bookCity.pojo.OrderBean;
import com.lzqedu.bookCity.pojo.User;
import com.lzqedu.bookCity.service.BookService;
import com.lzqedu.bookCity.service.CartItemService;
import com.lzqedu.bookCity.service.OrderBeanService;
import com.lzqedu.bookCity.service.OrderItemService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CartController {
    CartItemService cartItemService;
    OrderBeanService orderBeanService;
    public String index(HttpSession session){
        User user=(User)session.getAttribute("user");
        List<CartItem> cartItemList = cartItemService.getCartItemList(user);
        session.setAttribute("cartItemList",cartItemList);
        double totalAmount = cartItemService.totalAmount(user);
        session.setAttribute("totalAmount",totalAmount);
        int totalNumberOfItems = cartItemService.totalNumberOfItems(user);
        session.setAttribute("totalNumberOfItems",totalNumberOfItems);
        return "cart/cart";
    }
    public String addCart(HttpSession session,Integer bookId){
        User user=(User)session.getAttribute("user");
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);

        cartItemService.addCartItem(cartItem);
        return "redirect:cart.do";
    }
    public String editCart(Integer cartItemId,Integer buyCount){
        cartItemService.editCartItem(new CartItem(cartItemId,buyCount));
        return "redirect:cart.do";
    }
    public String cleanCart(HttpSession session){
        User user=(User)session.getAttribute("user");
        cartItemService.cleanCart(user);
        return "redirect:cart.do";
    }
    public String checkoutCart(HttpSession session){
        User user=(User)session.getAttribute("user");
        List<CartItem> cartItemList = cartItemService.getCartItemList(user);
        if (cartItemList != null){
            orderBeanService.addOrderBean(user);
            //最后一步清购物车
            cartItemService.cleanCart(user);
        }
        return "redirect:order.do";
    }
}
