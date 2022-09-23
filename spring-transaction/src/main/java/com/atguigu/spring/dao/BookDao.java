package com.atguigu.spring.dao;

public interface BookDao {
    /**
     * 根据图书ID查询图书价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 根据id更新库存信息，假设一次只能买一本书
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额信息
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
