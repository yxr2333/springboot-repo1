package com.example.spring.service;

import com.example.spring.entity.SmallClass;
import com.example.spring.entity.Subject;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:25 2021/11/3
 */
public interface SmallClassService {
    /**
     *
     * @return List<SmallClass> 所有的班级列表
     */
    List<SmallClass> getAll();

    /**
     *
     * @param id 班级id
     * @return 班级信息
     */
    SmallClass getOne(Integer id);

    /**
     *
     * @param smallClass 班级信息
     * @return 保存到数据库中的班级信息
     */
    SmallClass addOne(SmallClass smallClass);

    /**
     *
     * @param smallClass 需要修改的班级信息（要包含id）
     * @return 数据库中修改后的班级信息
     */
    SmallClass updateOne(SmallClass smallClass);

    /**
     *
     * @param id 被删除的班级的id
     */
    void deleteOne(Integer id);
}
