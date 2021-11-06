package com.example.web.springbootweb.controller;

import com.example.web.springbootweb.entity.Information;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.DataScarcityException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.InformationService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sound.sampled.Line;
import java.util.List;

/**
* Created by IDEA
* @author Xinrui Yu
* @date 2021/11/6
**/
@RestController
@RequestMapping("/info")
public class InformationController {

    @Resource
    private InformationService informationService;

    @GetMapping("/all")
    public Result getAll(){
        List<Information> informationList = informationService.getAll();
        return Result.success(informationList);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id) throws DataNotFoundException {
        Information information = informationService.getOne(id);
        return Result.success(information);
    }

    @PostMapping("")
    public Result addOne(@RequestBody Information information) throws DataScarcityException {
        Information savedInformation = informationService.addOne(information);
        return Result.success(savedInformation);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody Information information) throws DataNotFoundException, IdNotFoundException {
        Information updatedInformation = informationService.updateOne(information);
        return Result.success(updatedInformation);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id) throws DataNotFoundException {
        informationService.deleteOne(id);
        return Result.success(null);
    }
}
