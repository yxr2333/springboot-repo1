package com.example.web.springbootweb.dao;

import com.example.web.springbootweb.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 19:57
**/

@Repository
public interface LinkDao extends JpaRepository<Link, Integer> {
}