package com.test.spring6;

import com.test.spring6.config.SpringConfig;
import com.test.spring6.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testTxAnnotation {

    @Test
    public void testTxAllAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        Integer[] bookIds = {1, 2};
        bookController.checkoutBuyBook(bookIds, 1);
    }
}
