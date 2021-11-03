package com.example.spring.config;

import com.example.spring.utils.Result;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:07 2021/11/3
 */
@Configuration
@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e){
        return Result.failed(e);
    }
}
