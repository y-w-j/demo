package com.example.demo.service;

import com.example.demo.entity.user;

import java.util.List;

public interface UserService {
    public int insert(user use);
    public user findbyname(String username);
    public user selectById(int id);
    List<Integer> selectAllUser(int id);
}
