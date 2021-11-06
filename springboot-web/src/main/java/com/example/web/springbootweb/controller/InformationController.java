package com.example.web.springbootweb.controller;

import com.example.web.springbootweb.entity.Information;
import com.example.web.springbootweb.service.InformationService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
