package com.ctgu.yxr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class SpringbootCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCommentApplication.class, args);
    }

}
