package com.example.demo.service.imp;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.user;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int insert(user use) {
        userDao.insert(use);
        return 1;
    }

    @Override
    public user findbyname(String username) {
        user use=new user();
        use=userDao.findByName(username);
        return use;
    }
    @Override
    public user selectById(int id){
        return userDao.selectById(id);
    }

    @Override
    public List<Integer> selectAllUser(int id) {
        return userDao.selectAllUser(id);
    }
}
