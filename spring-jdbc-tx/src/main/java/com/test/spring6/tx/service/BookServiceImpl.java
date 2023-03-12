package com.test.spring6.tx.service;

import com.test.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    // 买书的方法： 图书id 和 用户id
    @Override
    public void buyBook(Integer bookId, Integer userId) {

//        //TODO 模拟超时效果
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // 根据图书id查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);

        // 更新库存 -购买的图书
        bookDao.updateStock(bookId);

        // 更新用户余额
        bookDao.updateBalance(userId, price);

//        System.out.println(1/0);

    }
}
