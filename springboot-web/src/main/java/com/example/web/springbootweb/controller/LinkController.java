package com.example.web.springbootweb.controller;


import com.example.web.springbootweb.entity.Link;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.LinkService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 19:58
**/

@RestController
@RequestMapping("/link")
public class LinkController {

    @Resource
    private LinkService linkService;

    @GetMapping("/all")
    public Result getAll(){
        List<Link> links = linkService.getAll();
        return Result.success(links);
    }

    @GetMapping("/{id}")
    public Result getOneById(@PathVariable Integer id) throws DataNotFoundException {
        Link link = linkService.getOne(id);
        return Result.success(link);
    }

    @PostMapping("")
    public Result addOne(@RequestBody Link link){
        Link savedLink = linkService.addOne(link);
        return Result.success(savedLink);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody Link link) throws IdNotFoundException {
        Link updatedLink = linkService.updateOne(link);
        return Result.success(updatedLink);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id) throws DataNotFoundException {
        linkService.deleteOne(id);
        return Result.success(null);
    }
}
