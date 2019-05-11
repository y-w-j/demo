package com.example.demo.service;

import com.example.demo.entity.Score;

import java.util.List;

public interface ScoreService {
    List<Score> selectByUser(int userid);
    Score selectOne(int userid,int singid);
    int insertOne(Score score);
}
