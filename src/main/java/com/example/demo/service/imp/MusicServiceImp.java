package com.example.demo.service.imp;

import com.example.demo.dao.MusicDao;
import com.example.demo.entity.Music;
import com.example.demo.service.MusicSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImp implements MusicSrevice {

    @Autowired
    private  MusicDao musicDao;
    @Override
    public int insert(Music music) {
        musicDao.insert(music);
        return 0;
    }

    @Override
    public Music findById(int id) {
        Music music=musicDao.findById(id);
        return music;
    }

    @Override
    public Music findByName(String singname) {
        Music music=musicDao.findByName(singname);
        return music;
    }

    @Override
    public int deleteById(int id) {
        musicDao.deleteById(id);
        return 0;
    }

    @Override
    public List<Music> selectByCollect(int userid) {
        return musicDao.selectByCollect(userid);
    }

    @Override
    public int updateView(int id) {
        musicDao.updateView(id);
        return 0;
    }
}
