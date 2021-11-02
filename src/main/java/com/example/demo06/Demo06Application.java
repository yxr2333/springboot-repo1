package com.example.demo06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import xyz.erupt.core.annotation.EruptScan;

/**
 * @author 小喻同学
 */
@SpringBootApplication
@EntityScan
@EruptScan
@EnableSwagger2
public class Demo06Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo06Application.class, args);
    }
}