package com.example.web.springbootweb.service;

import com.example.web.springbootweb.dao.SubjectDao;
import com.example.web.springbootweb.entity.Subject;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;

import java.util.List;

/**
 * @author Xinrui Yu
 * @date 2021-11-6 0:44
 */
public interface SubjectService {
    /**
     * 获取所有的学科信息
     * @return 所有学科信息
     */
    List<Subject> getAll();


    /**
     * 根据id查询学科信息
     * @param id 学科id
     * @return 对应的学科信息
     * @throws DataNotFoundException 数据未找到
     */
    Subject getOne(Integer id) throws DataNotFoundException;

    /**
     * 添加单个学科
     * @param subject 学科信息
     * @return 保存后的学科信息
     * @throws DataAlreadyExistException 学科名字重复
     */
    Subject addOne(Subject subject) throws DataAlreadyExistException;


    /**
     * 更新学科的信息
     * @param subject 学科信息（需要包含id）
     * @return 修改后的学科信息
     * @throws IdNotFoundException 未输入编号
     * @throws DataNotFoundException 输入的编号不存在
     */
    Subject updateOne(Subject subject) throws IdNotFoundException,DataNotFoundException;

    /**
     * 根据id删除一个学科的信息
     * @param id 被删除的学科的id
     * @throws DataNotFoundException 学科不存在
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
