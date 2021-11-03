package com.example.spring.controller;

import com.example.spring.entity.SmallClass;
import com.example.spring.service.SmallClassService;
import com.example.spring.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:22 2021/11/3
 */
@Api(tags = "班级接口")
@RestController
@RequestMapping("/class")
public class SmallClassController {

    @Resource
    private SmallClassService smallClassService;

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        SmallClass smallClass = smallClassService.getOne(id);
        return Result.success(smallClass);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<SmallClass> classes = smallClassService.getAll();
        return Result.success(classes);
    }

    @PostMapping("")
    public Result addOne(@RequestBody SmallClass smallClass){
        SmallClass savedClass = smallClassService.addOne(smallClass);
        return Result.success(savedClass);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody SmallClass smallClass){
        SmallClass updatedClass = smallClassService.updateOne(smallClass);
        return Result.success(updatedClass);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id){
        smallClassService.deleteOne(id);
        return Result.success(null);
    }

}
