package com.example.demo.service;

import com.example.demo.entity.Music;

import java.util.List;

public interface MusicSrevice {
    int insert(Music music);
    Music findById(int id);
    Music findByName(String singname);
    int deleteById(int id);
    List<Music> selectByCollect(int userid);
    int updateView(int id);
}
