package com.test.spring6.tx.dao;

public interface BookDao {
    // 根据图书id查询图书的价格
    Integer getPriceByBookId(Integer bookId);

    // 更新库存 -购买的图书
    void updateStock(Integer bookId);

    // 更新用户余额
    void updateBalance(Integer userId, Integer price);
}
