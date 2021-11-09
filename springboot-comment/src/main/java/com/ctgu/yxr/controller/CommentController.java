package com.ctgu.yxr.controller;


import com.ctgu.yxr.annotation.PassToken;
import com.ctgu.yxr.entity.Comment;
import com.ctgu.yxr.exception.DataNotFoundException;
import com.ctgu.yxr.service.CommentService;
import com.ctgu.yxr.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/all")
    public Result getAll(){
        List<Comment> commentList = commentService.getAll();
        return Result.success(commentList);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id) throws DataNotFoundException {
        Comment comment = commentService.getOne(id);
        return Result.success(comment);
    }

    @PostMapping("")
    public Result addOne(@RequestBody Comment comment, HttpServletRequest request) throws DataNotFoundException {
        Comment savedComment = commentService.addOne(comment);
        Object username = request.getAttribute("username");
        System.out.println("username:" + username);
        return Result.success(savedComment);
    }
}
