package com.example.demo.dao;

import com.example.demo.entity.Mymusic;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MymusicDao {
    @Insert("Insert into mymusic(userid,singid) VALUES(#{userid},#{singid})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Mymusic mymusic);

    @Select("select * from mymusic where id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    Mymusic findById(int id);

    @Select("select * from mymusic where userid = #{userid} ")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    List<Mymusic> findByUserId(int id);

    @Select("select * from mymusic where userid = #{userid} and singid = #{singid}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    Mymusic findByUserSingId(Mymusic mymusic);

    @Delete("delete from music where id = #{id}")
    int deleteById(int id);
}
