package com.ctgu.yxr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 21:40
**/
@SpringBootApplication
@EntityScan
public class SpringbootCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCommentApplication.class, args);
    }

}
