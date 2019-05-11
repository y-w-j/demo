package com.example.demo.dao;

import com.example.demo.entity.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MusicDao {
    @Insert("Insert into music(singname,singer,singpath,imgpath) VALUES(#{singname},#{singer},#{singpath},#{imgpath}" +
            ")")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Music music);

    @Select("select * from music where id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    Music findById(int id);

    @Select("select * from music where singname = #{singname}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    Music findByName(String singname);

    @Delete("delete from music where id = #{id}")
    int deleteById(int id);

    List<Music> selectByCollect(int id);
    int updateView(int id);
}
