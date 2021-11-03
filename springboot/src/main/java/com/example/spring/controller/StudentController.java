package com.example.spring.controller;

import com.example.spring.entity.Student;
import com.example.spring.service.StudentSerivce;
import com.example.spring.utils.Result;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "添加学生",notes = "添加单个学生")
    @PostMapping("")
    public Result addOne(@RequestBody Student student){
        Student savedData = studentSerivce.addOne(student);
        return Result.success(savedData);
    }

    @ApiOperation(value = "删除学生",notes = "删除单个学生")
    @DeleteMapping("")
    public Result deleteOne(@RequestParam @ApiParam(value = "被删除学生的id",required = true,name = "id") Integer id){
        studentSerivce.deleteOne(id);
        return Result.success(null);
    }

    @ApiOperation(value = "更新学生信息",notes = "更新学生信息")
    @PutMapping("")
    public Result updateOne(@RequestBody Student student){
        Student updatedData = studentSerivce.updateOne(student);
        return Result.success(updatedData);
    }

    @ApiOperation(value = "给学生添加老师",notes = "给学生添加老师，老师必须是已经存在的")
    @PostMapping("/teacher")
    public Result addTeacher(
            @RequestParam(value = "teacher_id")
            @ApiParam(required = true,name = "teacher_id")
            Integer teacherId,

            @RequestParam(value = "student_id")
            @ApiParam(required = true,name = "student_id")
            Integer studentId
    ){
        studentSerivce.addTeacher(teacherId,studentId);
        return Result.success(null);
    }
}
