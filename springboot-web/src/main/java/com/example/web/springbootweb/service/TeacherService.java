package com.example.web.springbootweb.service;

import com.example.web.springbootweb.entity.Teacher;
import com.example.web.springbootweb.exception.DataAlreadyExsitException;
import com.example.web.springbootweb.exception.DataNotFoundException;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 22:26 2021/11/4
 */
public interface TeacherService {
    /**
     * 获取所有报名的小导师信息
     * @return 所有报名的小导师列表
     */
    List<Teacher> getAll();

    /**
     * 根据id查询报名小导师信息
     * @param id 小导师id
     * @return 小导师信息
     * @exception DataNotFoundException 查询的数据不存在
     */
    Teacher getOne(Integer id) throws DataNotFoundException;


    /**
     * 报名
     * @param teacher 报名信息
     * @return 存储到数据库中的信息
     * @throws DataAlreadyExsitException 学号已存在
     */
    Teacher addOne(Teacher teacher) throws DataAlreadyExsitException;

    /**
     * 更新
     * @param teacher 小导师信息
     * @return 更新后的小导师信息
     * @throws  DataNotFoundException 小导师信息未找到，无法更改
     */
    Teacher updateOne(Teacher teacher) throws DataNotFoundException;

    /**
     * 根据id删除小导师信息
     * @param id 被删除的小导师id
     * @throws DataNotFoundException 小导师信息未找到，无法更改
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
