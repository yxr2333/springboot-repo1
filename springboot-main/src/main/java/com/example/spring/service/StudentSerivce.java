package com.example.spring.service;

import com.example.spring.entity.Student;

import java.util.List;

/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 21:59 2021-11-02
*/
public interface StudentSerivce {
    /**
     * 获取所有学生列表
     * @return 所有学生列表
     */
    List<Student> getAll();

    /**
     * 根据id获取单个学生信息
     * @param id 学生id
     * @return 学生信息
     */
    Student getOne(Integer id);

    /**
     * 添加单个学生
     * @param student 学生信息
     * @return 存到数据库中的学生信息
     */
    Student addOne(Student student);

    /**
     * 更新学生信息
     * @param student 学生信息（包含id）
     * @return 更新后的学生信息
     */
    Student updateOne(Student student);

    /**
     * 根据id删除
     * @param id 学生id
     */
    void deleteOne(Integer id);

    /**
     * 给学生添加小导师
     * @param teacherId 小导师id
     * @param studentId 学生id
     */
    void addTeacher(Integer teacherId,Integer studentId);

    /**
     * 给学生添加班级
     * @param studentId 学生id
     * @param classId 班级id
     */
    void addClass(Integer studentId,Integer classId) throws Exception;
}
