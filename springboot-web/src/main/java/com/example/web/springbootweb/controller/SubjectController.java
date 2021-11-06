package com.example.web.springbootweb.controller;


import com.example.web.springbootweb.entity.Subject;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.SubjectService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yxr
 * @date 2021-11-6 0:43
 */
@CrossOrigin
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @GetMapping("/all")
    public Result getAll(){
        List<Subject> subjectList = subjectService.getAll();
        return Result.success(subjectList);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id) throws DataNotFoundException {
        Subject subject = subjectService.getOne(id);
        return Result.success(subject);
    }


    @PostMapping("")
    public Result addOne(@RequestBody Subject subject) throws DataAlreadyExistException {
        Subject savedSubject = subjectService.addOne(subject);
        return Result.success(savedSubject);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody Subject subject) throws IdNotFoundException, DataNotFoundException {
        Subject updatedSubject = subjectService.updateOne(subject);
        return Result.success(updatedSubject);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id) throws DataNotFoundException {
        subjectService.deleteOne(id);
        return Result.success(null);
    }
}
