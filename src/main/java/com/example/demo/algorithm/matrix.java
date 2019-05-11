package com.example.demo.algorithm;

import com.example.demo.entity.Score;
import com.example.demo.service.ScoreService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//获取数据矩阵
@RestController
@Component
public class matrix {
    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;

    @RequestMapping("/test1")
    public Map<Integer, Integer> getLogUser(int id) {
        List<Score> logscore = new ArrayList<Score>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        logscore = scoreService.selectByUser(id);
        for (Score score : logscore
        ) {
            map.put(score.getSingid(), score.getScore());
        }
        return map;
    }

    @RequestMapping("/test2")
    public Map<Integer, Map<Integer, Integer>> getOtherUser(int id) {
        List<Integer> userlist = new ArrayList<Integer>();
        Map<Integer, Map<Integer, Integer>> otherscore = new HashMap<Integer, Map<Integer, Integer>>();
        userlist = userService.selectAllUser(id);
        for (int userid : userlist
        ) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map = getLogUser(userid);
            otherscore.put(userid, map);
        }
        return otherscore;
    }

    public List<Integer> contrast(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        //Map<Integer,List<Integer>> list=new HashMap<Integer, List<Integer>>();
        //list保留两者都进行了评分的歌曲id
        List<Integer> list = new ArrayList<Integer>();
        //迭代器获取key值
        Iterator<Integer> iter1 = map1.keySet().iterator();
        Iterator<Integer> iter2 = map2.keySet().iterator();
        Integer key1 = iter1.next();
        Integer key2 = iter2.next();
        while (iter1.hasNext() && iter2.hasNext()) {
            if (key1 == key2) {
                list.add(key1);
                key2 = iter2.next();
                key1 = iter1.next();
            } else if (key1 > key2) {
                key2 = iter2.next();
            } else {
                key1 = iter1.next();
            }
        }
        if (key1 == key2) {
            list.add(key1);
        }
        return list;
    }
    public Map<Integer,Integer> getsame(Map<Integer,Integer> map,List<Integer> list){
        Map<Integer,Integer> result=new HashMap<Integer, Integer>();
        int i=0;
        for (Map.Entry<Integer,Integer> em:map.entrySet()
             ) {
            int key=em.getKey();
            if(key==list.get(i++)){
                result.put(key,em.getValue());
            }
            if (i==list.size()) break;
        }
        return result;
    }
}
