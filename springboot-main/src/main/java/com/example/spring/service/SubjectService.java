package com.example.spring.service;

import com.example.spring.dao.SubjectDao;
import com.example.spring.entity.Subject;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:25 2021/11/3
 */
public interface SubjectService {
    /**
     * 获取所有学科信息
     * @return 所有学科信息
     */
    List<Subject> getAll();

    /**
     * 根据id获取学科信息
     * @param id 学科id
     * @return 学科信息
     */
    Subject getOne(Integer id);

    /**
     *
     * @param subject 学科信息
     * @return 保存到数据库中的学科信息
     */
    Subject addOne(Subject subject);

    /**
     *
     * @param subject 需要修改的学科信息（要包含id）
     * @return 数据库中修改后的学科信息
     */
    Subject updateOne(Subject subject);

    /**
     *
     * @param id 被删除的学科的id
     */
    void deleteOne(Integer id);


}
