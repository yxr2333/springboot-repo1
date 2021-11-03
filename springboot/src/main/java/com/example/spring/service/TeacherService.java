package com.example.spring.service;

import com.example.spring.entity.Teacher;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:15 2021/11/3
 */
public interface TeacherService {
    /**
    * Created by Intellij IDEA
    * @Author: Xinrui Yu
    * @Date: Created in 11:16 2021-11-03
    * @return: List<Teacher>
    */
    List<Teacher> getAll();
    /**
    * Created by Intellij IDEA
    * @Author: Xinrui Yu
    * @Date: Created in 11:17 2021-11-03
    * @param id 教师id
    * @return: Teacher
    */
    Teacher getOne(Integer id);
}
