package com.example.demo.entity;

import java.io.Serializable;

public class Music implements Serializable {
    private int id;
    private String singname;
    private String singer;
    private String singpath;
    private String imapath;
    private int type;
    private int viewed;

    public String getSingpath() {
        return singpath;
    }

    public void setSingpath(String singpath) {
        this.singpath = singpath;
    }

    public String getImapath() {
        return imapath;
    }

    public void setImapath(String imapath) {
        this.imapath = imapath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingname() {
        return singname;
    }

    public void setSingname(String singname) {
        this.singname = singname;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
