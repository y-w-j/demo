package com.example.demo.dao;

import com.example.demo.entity.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreDao {
    List<Score> selectByUser(int userid);

    @Select("select * from score where userid=#{userid} and singid=#{singid}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    Score selectOne(@Param("userid") int userid,@Param("singid")int singid);

    @Insert("insert into score(userid,singid,score) VALUES(#{userid},#{singid},#{score})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertOne(Score score);

    int updatescore(Score score);

}
