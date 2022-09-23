package com.atguigu.spring.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定当前测试类在Spring环境中测试，可以直接通过依赖注入方式来获取IOC容器的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbctemplate.xml")
public class JdbcTemplateTest {
    //自动装配
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql, "root", "123", 23, "女", "123@qq.com");

    }

    @Test
    public void testSelect() {
        String sql = "select * from t_user where id = ?";

    }

}
