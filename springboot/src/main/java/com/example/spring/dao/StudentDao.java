package com.example.spring.dao;

import com.example.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 21:59 2021-11-02
*/
@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
}
