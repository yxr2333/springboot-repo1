package com.ctgu.yxr.controller;


import com.ctgu.yxr.annotation.PassToken;
import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;
import com.ctgu.yxr.service.UserService;
import com.ctgu.yxr.utils.JwtUtils;
import com.ctgu.yxr.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PassToken
    @GetMapping("/all")
    public Result getAll(){
        List<User> userList = userService.getAll();
        return Result.success(userList);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id) throws DataNotFoundException {
        User user = userService.getOne(id);
        return Result.success(user);
    }

    @PostMapping("")
    public Result addOne(@RequestBody User user) throws NoSuchAlgorithmException {
        User savedUser = userService.addOne(user);
        return Result.success(savedUser);
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println("username:" + user.getUsername());
        System.out.println("password:" + user.getPassword());
        Boolean flag = userService.login(user.getUsername(), user.getPassword());
        if(flag){
            String token = JwtUtils.createToken(user.getUsername());
            return Result.success(token);
        }else{
            return Result.failed("用户名或密码错误");
        }
    }
}
