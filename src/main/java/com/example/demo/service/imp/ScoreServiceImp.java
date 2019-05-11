package com.example.demo.service.imp;

import com.example.demo.dao.ScoreDao;
import com.example.demo.entity.Score;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImp implements ScoreService {
    @Autowired
    ScoreDao scoreDao;
    @Override
    public List<Score> selectByUser(int userid) {
        return scoreDao.selectByUser(userid);
    }

    @Override
    public Score selectOne(int userid, int singid) {
        return scoreDao.selectOne(userid,singid);
    }

    @Override
    public int insertOne(Score score) {
        int useid=score.getUserid();
        int singid=score.getSingid();
        if(scoreDao.selectOne(useid,singid)==null){
            scoreDao.insertOne(score);
        }else{
            scoreDao.updatescore(score);
        }
        return 0;
    }
}
