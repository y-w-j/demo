package com.example.demo.service;

import com.example.demo.entity.Mymusic;

import java.util.List;

public interface MymusicService {
    int insert(Mymusic mymusic);
    Mymusic findById(int id);
    List<Mymusic> findByUserId(int id);
    int deleteById(int id);
    boolean findByUserSingId(Mymusic mymusic);
}
