package com.example.web.springbootweb.dao;


import com.example.web.springbootweb.entity.SlideShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 20:43
**/
@Repository
public interface SlideShowDao extends JpaRepository<SlideShow,Integer> {
}
