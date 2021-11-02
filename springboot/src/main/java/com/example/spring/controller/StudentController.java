package com.example.spring.controller;

import com.example.spring.entity.Student;
import com.example.spring.service.StudentSerivce;
import com.example.spring.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 22:01 2021-11-02
*/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentSerivce studentSerivce;

    @GetMapping("/all")
    public Result getAll(){
        List<Student> studentList = studentSerivce.getAll();
        return Result.success(studentList);
    }
}
