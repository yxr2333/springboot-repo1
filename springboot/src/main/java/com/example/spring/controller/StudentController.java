package com.example.spring.controller;

import com.example.spring.entity.Student;
import com.example.spring.service.StudentSerivce;
import com.example.spring.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(tags = "学生接口")
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentSerivce studentSerivce;

    @ApiOperation(value = "获取所有的学生信息",notes = "获取所有的学生信息")
    @GetMapping("/all")
    public Result getAll(){
        List<Student> studentList = studentSerivce.getAll();
        return Result.success(studentList);
    }

    @ApiOperation(value = "通过id获取学生信息",notes = "获取单个学生的信息")
    @GetMapping("/{id}")
    public Result getOne(@PathVariable(name = "id") @ApiParam(required = true,value = "学生id", name = "id") Integer id){
        Student student = studentSerivce.getOne(id);
        return Result.success(student);
    }
}
