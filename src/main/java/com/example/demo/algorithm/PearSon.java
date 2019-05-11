package com.example.demo.algorithm;


import java.util.*;
import com.example.demo.algorithm.matrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//计算皮尔逊相关系数
@RestController
public class PearSon {

    @Autowired
     matrix mat;
    private Map<Integer,Integer> loguser=new HashMap<Integer,Integer>();
    private Map<Integer,Map<Integer,Integer>> otheruser=new HashMap<Integer, Map<Integer, Integer>>();
    @RequestMapping("/test4")
    public String getPearson(int id){
        Map<Integer,Double> pearsonsim=new HashMap<Integer, Double>();
        loguser=mat.getLogUser(id);
        otheruser=mat.getOtherUser(id);
        int i=0;
        String result="皮尔逊相关系数:";
        for (Map.Entry<Integer,Map<Integer,Integer>>user:otheruser.entrySet()
             ) {
            i++;
            Double sim;
            List<Integer> same=new ArrayList<Integer>();
            Map<Integer,Integer> map1=new HashMap<Integer, Integer>();
            Map<Integer,Integer> map2=new HashMap<Integer, Integer>();
            same=mat.contrast(loguser,user.getValue());
            System.out.println(same);
            map1=mat.getsame(loguser,same);
            map2=mat.getsame(user.getValue(),same);
            sim=getUserSimilar(map1,map2);
            pearsonsim.put(user.getKey(),sim);
            result=result+id+"与"+i+"之间的系数"+sim;

        }
        return result;
    }
    
    
    /**
     *
     * @Title getUserSimilar
     * @Class testRecommend
     * @return double
     * @param pm1
     * @param pm2
     * @return
     * @Description获取两个用户之间的皮尔逊相似度,相关系数的绝对值越大,相关度越大
     * @author qinshijiang
     * @Date 2013-9-4
     */
    public static double getUserSimilar(Map<Integer, Integer> pm1, Map<Integer, Integer> pm2) {
        int n = 0;// 数量n
        int sxy = 0;// Σxy=x1*y1+x2*y2+....xn*yn
        int sx = 0;// Σx=x1+x2+....xn
        int sy = 0;// Σy=y1+y2+...yn
        int sx2 = 0;// Σx2=(x1)2+(x2)2+....(xn)2
        int sy2 = 0;// Σy2=(y1)2+(y2)2+....(yn)2
        for (Map.Entry<Integer, Integer> pme : pm1.entrySet()) {
            Integer key = pme.getKey();
            Integer x = pme.getValue();
            Integer y = pm2.get(key);
            if (x != null && y != null) {
                n++;
                sxy += x * y;
                sx += x;
                sy += y;
                sx2 += Math.pow(x, 2);//求平方
                sy2 += Math.pow(y, 2);
            }
        }
        // p=(Σxy-Σx*Σy/n)/Math.sqrt((Σx2-(Σx)2/n)(Σy2-(Σy)2/n));
        double sd = sxy - sx * sy / n;
        double sm = Math.sqrt((sx2 - Math.pow(sx, 2) / n) * (sy2 - Math.pow(sy, 2) / n));
        //return (sm == 0 ? 1 : sd / sm);
        return Math.abs(sm == 0 ? 1 : sd / sm);//返回绝对值
    }

    /**
     *
     * @Title getRecommend
     * @Class testRecommend
     * @return String
     * @param simUserObjMap
     * @param simUserSimMap
     * @return
     * @Description根据相关系数得到推荐物品
     * @author qinshijiang
     * @Date 2013-9-4
     */
    public static Integer getRecommend(Map<Integer, Map<Integer, Integer>> simUserObjMap, Map<Integer, Double> simUserSimMap) {
        Map<Integer, Double> objScoreMap = new HashMap<Integer, Double>();
        for (Map.Entry<Integer, Map<Integer, Integer>> simUserEn : simUserObjMap.entrySet()) {
            Integer user = simUserEn.getKey();
            double sim = simUserSimMap.get(user);
            System.out.println(user+"之间的相关系数:"+sim);
            for (Map.Entry<Integer, Integer> simObjEn : simUserEn.getValue().entrySet()) {
                double objScore = sim * simObjEn.getValue();
                Integer objName = simObjEn.getKey();
                if (objScoreMap.get(objName) == null) {
                    objScoreMap.put(objName, objScore);
                }else {
                    double totalScore = objScoreMap.get(objName);
                    objScoreMap.put(objName, totalScore + objScore);
                }
                System.out.println(objName+":"+objScoreMap.get(objName));
            }
        }
        List<Map.Entry<Integer, Double>> enList = new ArrayList<Map.Entry<Integer, Double>>(objScoreMap.entrySet());
        Collections.sort(enList, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                Double a = o1.getValue() - o2.getValue();
                if (a == 0) {
                    return 0;
                }else if (a > 0) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return enList.get(enList.size() - 1).getKey();
    }
}
