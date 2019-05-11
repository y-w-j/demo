package com.example.demo.dao;

import com.example.demo.entity.student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudenDao {
    @Insert("Insert into student(name,age) VALUES(#{name},#{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(student stu);

    @Select("select * from student where id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    student findById(int id);
}
