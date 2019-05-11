package com.example.demo.controller;

import com.example.demo.entity.Music;
import com.example.demo.entity.Mymusic;
import com.example.demo.entity.Result;
import com.example.demo.entity.Score;
import com.example.demo.service.MusicSrevice;
import com.example.demo.service.MymusicService;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MusicController {
    @Autowired
    private MusicSrevice musicSrevice;
    @Autowired
    private MymusicService mymusicService;
    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/collect")
    @ResponseBody
    public Result collect(Mymusic mymusic){
        Result result=new Result();
        System.out.print(mymusic.getSingid()+"\n");
        if(mymusicService.findByUserSingId(mymusic))
        {
            result.setCode(1);
        }else {
            mymusicService.insert(mymusic);
            result.setCode(2);

        }
            return result;
    }
    @RequestMapping("/searchname")
    public String search(String name, Map<String,Object> map){
        Music music=new Music();
        music=musicSrevice.findByName(name);
        List<Music> list=new ArrayList<Music>();
        list.add(music);
        map.put("search",list);
        return "/search";
    }
    @RequestMapping("/addscore")
    @ResponseBody
    public Result addscore(Score score){
        System.out.println(score.getUserid());
        Result result=new Result();
        try{
            scoreService.insertOne(score);
            result.setCode(2);
        }catch (Exception e){
            result.setCode(1);
            result.setMessage(e.getMessage());
        }finally {
            return result;
        }

    }

    @RequestMapping("/scoretest")
    @ResponseBody
    public Score test(){
        return scoreService.selectOne(1,1);
    }
}
