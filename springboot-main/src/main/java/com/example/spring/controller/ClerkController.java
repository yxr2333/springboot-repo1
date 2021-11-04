package com.example.spring.controller;


import com.example.spring.entity.Clerk;
import com.example.spring.service.ClerkService;
import com.example.spring.utils.Result;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:23 2021/11/3
 */

@Api(tags = "对接干事接口")
@RestController
@RequestMapping("/clerk")
public class ClerkController {
    @Resource
    private ClerkService clerkService;
    
    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        Clerk clerk = clerkService.getOne(id);
        return Result.success(clerk);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<Clerk> clerks = clerkService.getAll();
        return Result.success(clerks);
    }

    @PostMapping("")
    public Result addOne(@RequestBody Clerk clerk){
        Clerk savedClerk = clerkService.addOne(clerk);
        return Result.success(savedClerk);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody Clerk clerk){
        Clerk updatedClerk = clerkService.updateOne(clerk);
        return Result.success(updatedClerk);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id){
        clerkService.deleteOne(id);
        return Result.success(null);
    }
    @PostMapping("/class")
    public Result addClass(
            @RequestParam(value = "clerk_id") Integer clerkId,
            @RequestParam(value = "class_id") Integer classId
    ){
        Clerk clerk = clerkService.addClass(clerkId, classId);
        return Result.success(clerk);
    }
}
