package com.example.spring.controller;

import com.example.spring.entity.Subject;
import com.example.spring.service.SubjectService;
import com.example.spring.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:22 2021/11/3
 */

@RestController
@RequestMapping("/subject")
@Api(tags = "学科信息接口")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @ApiOperation(value = "根据id获取学生的信息",notes = "根据id获取学生的信息")
    @GetMapping("/{id}")
    public Result getOne(@PathVariable @ApiParam(name = "id",value = "学科id",required = true) Integer id){
        Subject subject = subjectService.getOne(id);
        return Result.success(subject);
    }
    @ApiOperation(value = "获取所有的学科信息")
    @GetMapping("/all")
    public Result getAll(){
        List<Subject> subjectList = subjectService.getAll();
        return Result.success(subjectList);
    }
    @ApiOperation(value = "增加一门学科")
    @PostMapping("")
    public Result addOne(@RequestBody Subject subject){
        Subject savedSubject = subjectService.addOne(subject);
        return Result.success(savedSubject);
    }

    @ApiOperation(value = "修改一门学科的信息",notes = "必须包含学科的id")
    @PutMapping("")
    public Result updateOne(@RequestBody Subject subject){
        Subject updatedSubject = subjectService.updateOne(subject);
        return Result.success(updatedSubject);
    }

    @ApiOperation(value = "删除一门学科",notes = "根据id删除")
    @DeleteMapping("")
    public Result deleteOne(@RequestParam @ApiParam(name = "id",value = "学科id",required = true) Integer id){
        subjectService.deleteOne(id);
        return Result.success(null);
    }
}
