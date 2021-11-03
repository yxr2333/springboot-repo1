package com.example.spring.service.impl;

import com.example.spring.dao.TeacherDao;
import com.example.spring.entity.Teacher;
import com.example.spring.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:18 2021/11/3
 */
@Service(value = "teacherService")
@Transactional(rollbackFor = {})
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherDao teacherDao;

    /**
     * Created by Intellij IDEA
     *
     * @Author: Xinrui Yu
     * @Date: Created in 11:16 2021-11-03
     * @return: List<Teacher>
     */
    @Override
    public List<Teacher> getAll() {
        return teacherDao.findAll();
    }

    /**
     * Created by Intellij IDEA
     *
     * @param id 教师id
     * @Author: Xinrui Yu
     * @Date: Created in 11:17 2021-11-03
     * @return: Teacher
     */
    @Override
    public Teacher getOne(Integer id) {
        return teacherDao.findById(id).get();
    }

    /**
     * 添加小导师
     *
     * @param teacher 添加的教师信息
     * @return 保存在数据库中教师的信息
     */
    @Override
    public Teacher addOne(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    /**
     * 更新小导师的信息
     *
     * @param teacher 需要被修改的小导师的信息（需要包含id）
     * @return 数据库中修改后的小导师信息
     */
    @Override
    public Teacher updateOne(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    /**
     * 根据id删除小导师
     *
     * @param id 被删除的小导师的id
     */
    @Override
    public void deleteOne(Integer id) {
        teacherDao.deleteById(id);
    }
}
