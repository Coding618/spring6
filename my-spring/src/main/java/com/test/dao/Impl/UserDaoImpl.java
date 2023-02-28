package com.test.dao.Impl;

import com.test.annotation.Bean;
import com.test.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao  ......   ");
    }
}
