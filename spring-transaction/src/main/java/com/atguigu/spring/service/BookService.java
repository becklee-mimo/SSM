package com.atguigu.spring.service;

public interface BookService {
    /**
     * 用户买书
     * @param bookId
     * @param userId
     */
    void buyBook(Integer bookId, Integer userId);
}
