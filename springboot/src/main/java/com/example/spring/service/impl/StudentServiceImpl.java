package com.example.spring.service.impl;

import com.example.spring.dao.StudentDao;
import com.example.spring.entity.Student;
import com.example.spring.service.StudentSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 22:01 2021-11-02
*/
@Service
public class StudentServiceImpl implements StudentSerivce {

    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> getAll() {
        List<Student> studentList = studentDao.findAll();
        return studentList;
    }
}
