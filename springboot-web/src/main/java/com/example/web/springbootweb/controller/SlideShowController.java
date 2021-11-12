package com.example.web.springbootweb.controller;

import com.example.web.springbootweb.dao.SlideShowDao;
import com.example.web.springbootweb.entity.SlideShow;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.SlideShowService;
import com.example.web.springbootweb.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @date 2021/11/12 21:00 星期五
 */
@RestController
@RequestMapping("/slide")
public class SlideShowController {

    @Resource
    private SlideShowService slideShowService;

    @GetMapping("/all")
    public Result getAll(){
        List<SlideShow> slideShowList = slideShowService.getAll();
        return Result.success(slideShowList);
    }

    @GetMapping("/{id}")
    public Result getOneById(@PathVariable Integer id) throws DataNotFoundException {
        SlideShow slideShow = slideShowService.getOneById(id);
        return Result.success(slideShow);
    }

    @PostMapping("")
    public Result addOne(@RequestBody SlideShow slideShow){
        SlideShow savedOne = slideShowService.addOne(slideShow);
        return Result.success(savedOne);
    }

    @PutMapping("")
    public Result updateOne(@RequestBody SlideShow slideShow) throws IdNotFoundException {
        SlideShow updateData = slideShowService.updateOne(slideShow);
        return Result.success(updateData);
    }

    @DeleteMapping("")
    public Result deleteOne(@RequestParam Integer id) throws DataNotFoundException {
        slideShowService.deleteOne(id);
        return Result.success(null);
    }
}
