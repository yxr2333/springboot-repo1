package com.example.spring.dao;

import com.example.spring.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:14 2021/11/3
 */
@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
}
