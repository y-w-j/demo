package com.example.demo.entity;

import java.io.Serializable;

public class Score implements Serializable {
    private int id;
    private int userid;
    private int singid;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getSingid() {
        return singid;
    }

    public void setSingid(int singid) {
        this.singid = singid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
