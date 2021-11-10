package com.example.web.springbootweb.controller;

import com.example.web.springbootweb.entity.Student;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.StudentService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxr
 * @date 2021-11-6 0:04
 */
@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id) throws DataNotFoundException {
        Student student = studentService.getOne(id);
        return Result.success(student);
    }

    @GetMapping("/all")
    public Result getAll(){
        List<Student> studentList = studentService.getAll();
        return Result.success(studentList);
    }

    @PostMapping("")
    public Result addOne(@RequestBody Student student) throws DataAlreadyExistException {
        Student savedStudent = studentService.addOne(student);
        return Result.success(savedStudent);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody Student student) throws IdNotFoundException, DataNotFoundException {
        Student updatedStudent = studentService.updateOne(student);
        return Result.success(updatedStudent);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id) throws DataNotFoundException {
        studentService.deleteOne(id);
        return Result.success(null);
    }


    @GetMapping("/name")
    public Result getAllByName(@RequestParam String name){
        List<Student> students = studentService.getStudentsByName(name);
        return Result.success(students);
    }

    @GetMapping("/college")
    public Result getAllByCollegeName(@RequestParam String name){
        List<Student> students = studentService.getStudentsByCollege(name);
        return Result.success(students);
    }
}
