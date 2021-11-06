package com.example.web.springbootweb.service;

import com.example.web.springbootweb.entity.Student;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;

import java.util.List;


/**
 * @author Xinrui Yu
 * @date 2021-11-6 9:27
 */
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
     * 根据学生的姓名筛选所有相近姓名的学生
     * @param name 学生的姓名
     * @return 学生列表
     */
    List<Student> getStudentsByName(String name);

    /**
     * 根据学院查询对应的所有学生
     * @param name 学院名称
     * @return 学生列表
     */
    List<Student> getStudentsByCollege(String name);
    /**
     * 添加一名学生
     * @param student 学生信息
     * @return 保存到数据库中的学生信息
     * @throws DataAlreadyExistException 学号重复
     */
    Student addOne(Student student) throws DataAlreadyExistException;
    /**
     * 更新学生信息
     * @param student 更新的学生信息
     * @return 更新后的学生信息
     * @throws DataNotFoundException 数据未找到
     * @throws IdNotFoundException 编号不存在
     */
    Student updateOne(Student student) throws DataNotFoundException, IdNotFoundException;

    /**
     * 根据id删除学生信息
     * @param id 学生id
     * @throws DataNotFoundException 数据不存在
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
