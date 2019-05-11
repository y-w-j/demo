package com.example.demo.controller;

import com.example.demo.entity.Music;
import com.example.demo.entity.student;
import com.example.demo.service.MusicSrevice;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Peng
 * Time: 2016/12/16 15:45
 */
@Controller
public class HelloController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MusicSrevice musicSrevice;
    @RequestMapping("/")
    public String say(Map<String,String> map){
        String mp3 = "沙漠骆驼.mp3";
        map.put("mp3",mp3);
        return "/index";
    }

    @RequestMapping("/play")
    public String play(Map<String,Object> map){
        List<Music> musicList=new ArrayList<Music>();
        musicList=musicSrevice.selectByCollect(1);
        map.put("playlist",musicList);
        return "/play";
    }

    @RequestMapping("/category")
    public String category(Map<String,String> map){
        return "/category";
    }

    @RequestMapping("/singer")
    public String singer(Map<String,String> map){
        return "/singer";
    }

    @RequestMapping("/login")
    public String login(Map<String,String> map){
        return "/login";
    }

    @RequestMapping("/mymusic")
    public String mymusic(){
        return "/mymusic";
    }

    //@GetMapping("add")
   @RequestMapping("/add")
    public String insert(@RequestParam("age") String age,  String name,HttpServletRequest request){
         student stu = new student();
         int Age=Integer.parseInt(age);
         stu.setAge(Age);
         stu.setName(request.getParameter("name"));
         //stu.setName(name);
         studentService.add(stu);
         return "/success";
    }

    @RequestMapping("/search")
    public String search(Map<String, Object> result){
        student stu = new student();
        stu=studentService.findbyid(2);
        System.out.print(stu.getName());
        result.put("stu",stu);
        return "/result";
    }

    @RequestMapping("/result")
    public String result(@ModelAttribute("stu") student stu){
        return "/test";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
//        student stu=new student();
//        model.addAttribute("stu",stu);
        return "/hello";
    }

    @RequestMapping("/free")
    public String index(Map<String, Object> result) {
        result.put("name", "yushengjun");
        result.put("sex", "0");
        List<student> listResult = new ArrayList<student>();
        student stu =new student();
        stu.setName("xxx");
        stu.setAge(18);
        listResult.add(stu);
        stu =new student();
        stu.setName("yyy");
        stu.setAge(19);
        listResult.add(stu);
        result.put("stu",stu);
        result.put("listResult", listResult);
        return "/result";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        student stu =new student();
        model.addAttribute("stu", stu);
        return "greeting";
    }

    @PostMapping("/xxx")
    public String greetingSubmit(@ModelAttribute("stu") student stu) {
        System.out.print(stu.getAge());
        System.out.print(stu.getName());
        System.out.print("xxx");
        //return stu;
        return "reuslt";
    }

    @RequestMapping("/zzz")
    public String zzz() {
        //return stu;
        return "test";
    }

    @RequestMapping("/yyy")
    @ResponseBody
    public student testjson( student stu,HttpServletRequest request) {

        System.out.print(stu.getAge());
        System.out.print(stu.getName()+"\n");
       // System.out.print(request.getParameter("age"));
        System.out.print("yyy");
        //return stu;
        return stu;
    }

}
