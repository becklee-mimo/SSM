package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //1.查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //2.更新图书的库存
        bookDao.updateStock(bookId);
        //3.更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
