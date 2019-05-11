package com.example.demo.service.imp;

import com.example.demo.dao.MymusicDao;
import com.example.demo.entity.Mymusic;
import com.example.demo.service.MymusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MymusicServiceImp implements MymusicService {
    @Autowired
    MymusicDao mymusicDao;
    @Override
    public int insert(Mymusic mymusic) {
        mymusicDao.insert(mymusic);
        return 0;
    }

    @Override
    public Mymusic findById(int id) {
        Mymusic mymusic=mymusicDao.findById(id);
        return mymusic;
    }

    @Override
    public List<Mymusic> findByUserId(int id) {
        return mymusicDao.findByUserId(id);
    }

    @Override
    public int deleteById(int id) {
        mymusicDao.deleteById(id);
        return 0;
    }
    @Override
    public boolean findByUserSingId(Mymusic mymusic){

        if(mymusicDao.findByUserSingId(mymusic)==null)
            return false;
        else return true;
    }
}
