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
     * 获取所有班级列表
     * @return List<SmallClass> 所有的班级列表
     */
    List<SmallClass> getAll();

    /**
     * 根据id查询班级信息
     * @param id 班级id
     * @return 班级信息
     */
    SmallClass getOne(Integer id);

    /**
     * 添加一个班级
     * @param smallClass 班级信息
     * @return 保存到数据库中的班级信息
     */
    SmallClass addOne(SmallClass smallClass);

    /**
     * 修改一个班级
     * @param smallClass 需要修改的班级信息（要包含id）
     * @return 数据库中修改后的班级信息
     */
    SmallClass updateOne(SmallClass smallClass);

    /**
     * 删除一个班级
     * @param id 被删除的班级的id
     */
    void deleteOne(Integer id);

    /**
     * 给班级添加学生
     * @param studentId 学生id
     * @param classId 班级id
     */
    void addStudent(Integer studentId,Integer classId) throws Exception;

    /**
     * 给班级设置小导师
     * @param classId 班级id
     * @param teacherId 小导师id
     */
    void setTeacher(Integer classId,Integer teacherId);

    /**
     * 给班级设置干事
     * @param classId 班级id
     * @param clerkId 干事id
     * @return: 修改后的班级信息
     */
    SmallClass setClerk(Integer classId,Integer clerkId);
}
