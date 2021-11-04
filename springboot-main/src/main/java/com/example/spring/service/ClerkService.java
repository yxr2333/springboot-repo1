package com.example.spring.service;

import com.example.spring.entity.Clerk;
import com.example.spring.entity.SmallClass;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:25 2021/11/3
 */
public interface ClerkService {
    /**
     * 获取所有的干事列表
     * @return 干事列表
     */
    List<Clerk> getAll();

    /**
     * 根据id获取干事信息
     * @param id 干事id
     * @return 对应的干事信息
     */
    Clerk getOne(Integer id);

    /**
     * 增加新的干事
     * @param clerk 添加的干事信息
     * @return 保存到数据库中的干事信息
     */
    Clerk addOne(Clerk clerk);

    /**
     * 修改干事信息
     * @param clerk 修改的干事信息（需要包含id）
     * @return 修改后保存到数据库中的信息
     */
    Clerk updateOne(Clerk clerk);

    /**
     * 根据id删除干事信息
     * @param id 需要被删除的干事的id
     */
    void deleteOne(Integer id);

    /**
     * 给干事添加班级
     * @param clerkId 干事id
     * @param classId 班级id
     * @return: Clerk 修改后的干事信息
     */
    Clerk addClass(Integer clerkId,Integer classId);
}
