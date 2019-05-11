package com.example.demo.service.imp;

import com.example.demo.dao.StudenDao;
import com.example.demo.entity.student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudenDao studenDao;

    @Override
    public int add(student stu) {
        studenDao.insert(stu);
        return 1;
    }

    @Override
    public student findbyid(int id){
        student stu = new student();
        stu =studenDao.findById(id);
        return stu;
    }
}
