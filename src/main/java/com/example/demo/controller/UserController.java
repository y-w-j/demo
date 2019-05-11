package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Result;
import com.example.demo.entity.user;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/log")
    public String login(user use){
        user use2=new user();
        System.out.print(use.getUsername()+"\n");
        System.out.print(use.getPassword());
        System.out.print("c");
        use2=userService.findbyname(use.getUsername());
        if(use2==null){
            return "/index";
        }else{
            if(!use2.getPassword().equals(use.getPassword()))
                return "/success";
        }
        return "/index";
    }
    @RequestMapping("/log2")
    @ResponseBody
    public Result login2(user use){
        user use2=new user();
        Result result=new Result();
        System.out.print(use.getUsername()+"\n");
        System.out.print("a");
        System.out.print(use.getPassword()+"\n");
        System.out.print("b");
        use2=userService.findbyname(use.getUsername());
        if(use2==null){
            result.setCode(1);
            return result;
        }else{
            if(!use2.getPassword().equals(use.getPassword()))
            { result.setCode(2);
                return result;}
        }
        result.setCode(3);
        result.setMessage(String.valueOf(use2.getId()));
        return result;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result register(user use){
        user use2=new user();
        Result result=new Result();
        System.out.print(use.getUsername()+"\n");
        System.out.print("a");
        System.out.print(use.getPassword()+"\n");
        System.out.print("b");
        use2=userService.findbyname(use.getUsername());
        if(use2==null){
            userService.insert(use);
            result.setCode(2);
            return result;
        }else{
            result.setCode(1);
            return result;
        }

    }
    @RequestMapping("/maptest")
    @ResponseBody
    public user maptest(){
        return userService.selectById(1);
    }
}
