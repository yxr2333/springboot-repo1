package com.example.web.springbootweb;

import com.example.web.springbootweb.entity.Link;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.service.LinkService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootWebApplicationTests {


    @Resource
    private LinkService linkService;
    @Test
    void findLinkById() throws DataNotFoundException {
        Integer id = 2;
        Link link = linkService.getOne(id);
        System.out.println(link);
    }

}
