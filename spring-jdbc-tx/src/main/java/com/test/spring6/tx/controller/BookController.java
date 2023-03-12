package com.test.spring6.tx.controller;

import com.test.spring6.tx.service.BookService;
import com.test.spring6.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

//    @Autowired
//    private BookService bookService;
//
//    public void  buyBook(Integer bookId, Integer userId) {
//
//        // 买书的方法： 图书id 和 用户id
//        bookService.buyBook(bookId, userId);
//    }

    @Autowired
    private CheckoutService checkoutService;

    public void checkoutBuyBook(Integer[] bookIds, Integer userId) {
        checkoutService.checkout(bookIds, userId);
    }
}
