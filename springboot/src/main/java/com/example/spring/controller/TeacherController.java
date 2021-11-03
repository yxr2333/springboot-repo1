package com.example.spring.controller;

import com.example.spring.entity.Teacher;
import com.example.spring.service.TeacherService;
import com.example.spring.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:19 2021/11/3
 */
@Api(tags = "小导师接口")
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

    @PostMapping("")
    public Result addOne(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.addOne(teacher);
        return Result.success(savedTeacher);
    }
    @PutMapping("")
    public Result updateOne(@RequestBody Teacher teacher){
        Teacher updatedTeacher = teacherService.updateOne(teacher);
        return Result.success(updatedTeacher);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id){
        teacherService.deleteOne(id);
        return Result.success(null);
    }
}
