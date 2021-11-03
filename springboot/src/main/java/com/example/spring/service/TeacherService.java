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

    /**
     * 添加小导师
     * @param teacher 添加的教师信息
     * @return 保存在数据库中教师的信息
     */
    Teacher addOne(Teacher teacher);

    /**
     * 更新小导师的信息
     * @param teacher 需要被修改的小导师的信息（需要包含id）
     * @return 数据库中修改后的小导师信息
     */
    Teacher updateOne(Teacher teacher);

    /**
     * 根据id删除小导师
     * @param id 被删除的小导师的id
     */
    void deleteOne(Integer id);
}
