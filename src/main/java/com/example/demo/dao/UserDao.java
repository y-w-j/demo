package com.example.demo.dao;

import com.example.demo.entity.student;
import com.example.demo.entity.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Insert("Insert into user(username,password) VALUES(#{username},#{password})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(user use);

    @Select("select * from user where username = #{username}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    user findByName(String username);

    user selectById(int id);

    List<Integer> selectAllUser(int id);
}
