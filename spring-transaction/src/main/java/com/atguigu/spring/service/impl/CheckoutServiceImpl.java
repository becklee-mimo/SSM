package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.dao.impl.BookDaoImpl;
import com.atguigu.spring.service.BookService;
import com.atguigu.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for(Integer bookId : bookIds) {
            bookService.buyBook(bookId, userId);
        }
    }
}
