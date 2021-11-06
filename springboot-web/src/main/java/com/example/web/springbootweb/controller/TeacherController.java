package com.example.web.springbootweb.controller;

import com.example.web.springbootweb.entity.Subject;
import com.example.web.springbootweb.entity.Teacher;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.TeacherService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:26 2021/11/4
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
    public Result getOne(@PathVariable Integer id) throws DataNotFoundException {
        Teacher teacher = teacherService.getOne(id);
        return Result.success(teacher);
    }

    @PostMapping("")
    public Result addOne(@RequestBody Teacher teacher) throws DataAlreadyExistException {
        List<Subject> subjects = teacher.getSubjects();
        System.out.println(subjects);
        Teacher savedTeacher = teacherService.addOne(teacher);
        return Result.success(savedTeacher);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody Teacher teacher) throws DataNotFoundException, IdNotFoundException {
        Teacher updatedTeacher = teacherService.updateOne(teacher);
        return Result.success(updatedTeacher);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id) throws DataNotFoundException{
        teacherService.deleteOne(id);
        return Result.success(null);
    }
}
