package com.agtuigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //开启分页功能，返回的是
        //Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4,
        // total=30, pages=8, reasonable=false, pageSizeZero=false}
        //再加上当前页的Emp的数据
        Page<Object> page = PageHelper.startPage(1, 4);

        List<Emp> emps = mapper.selectByExample(null);
        //navigatePage就是导航页，比如当前是第三页
        //首页 上一页 1 2 3 4 5下一页 尾页
        PageInfo<Emp> pageInfo = new PageInfo<>(emps, 5);
        emps.forEach(System.out::println);
        System.out.println("page = " + page);
        System.out.println("pageInfo = " + pageInfo);
        //pageInfo = PageInfo{pageNum=1, pageSize=4, size=4, startRow=1, endRow=4, total=30, pages=8,
        // list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=30, pages=8,
        // reasonable=false, pageSizeZero=false
        // prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true,
        // navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}


    }
}
