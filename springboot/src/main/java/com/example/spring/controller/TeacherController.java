package com.example.spring.controller;

import com.example.spring.entity.Teacher;
import com.example.spring.service.TeacherService;
import com.example.spring.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:19 2021/11/3
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @GetMapping("/all")
    public Result getAll(){
        List<Teacher> teacherList = teacherService.getAll();
        return Result.success(teacherList);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        Teacher teacher = teacherService.getOne(id);
        return Result.success(teacher);
    }
}
