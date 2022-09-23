package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 查询用户总数量
     * @return
     */
    Integer getCount();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserToMap(@Param("id") int id);

    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，此
    时可以将这些map放在一个list集合中获取
     */
    List<Map<String,Object>> getAllUserToMap();
//    @MapKey("id")
//    Map<String,Object> getAllUserToMap();
}
