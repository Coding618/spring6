package com.test.spring6.tx.service;

public interface BookService {

    // 买书的方法： 图书id 和 用户id
    void buyBook(Integer bookId, Integer userId);
}
