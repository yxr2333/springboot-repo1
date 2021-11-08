package com.ctgu.yxr.config;

import com.ctgu.yxr.utils.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:26 2021/11/4
 */
@Configuration
@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e){
        return Result.failed(e);
    }
}
