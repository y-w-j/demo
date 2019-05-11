package com.example.demo.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class student implements Serializable {
    private int id;
    @NotNull(message="名字不能为空")
    private  String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
