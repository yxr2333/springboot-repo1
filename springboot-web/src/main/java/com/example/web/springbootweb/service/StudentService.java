package com.example.web.springbootweb.service;

import com.example.web.springbootweb.entity.Student;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;

import java.util.List;

public interface StudentService {
    /**
     * 获取所有的学生信息
     * @return 数据库中所有的学生信息
     */
    List<Student> getAll();

    /**
     * 根据id查询学生信息
     * @param id 学生id
     * @return 学生信息
     * @throws DataNotFoundException 学生信息未找到
     */
    Student getOne(Integer id) throws DataNotFoundException;

    /**
     * 添加一名学生
     * @param student 学生信息
     * @return 保存到数据库中的学生信息
     * @throws DataAlreadyExistException 学号重复
     */
    Student addOne(Student student) throws DataAlreadyExistException;
    // TODO: 2021/11/6 1、需要对不包含id的情况进行处理，抛出IdNotFoundException
    // TODO: 2021/11/6 2、需要对传入的id进行判断，看是否存在，不存在的直接抛出DataNotFoundException
    /**
     * 更新学生信息
     * @param student 更新的学生信息
     * @return 更新后的学生信息
     */
    Student updateOne(Student student);

    /**
     * 根据id删除学生信息
     * @param id 学生id
     * @throws DataNotFoundException 数据不存在
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
