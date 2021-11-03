package com.example.spring.service;

import com.example.spring.entity.Student;

import java.util.List;

/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 21:59 2021-11-02
*/
public interface StudentSerivce {
    List<Student> getAll();
    Student getOne(Integer id);
}
