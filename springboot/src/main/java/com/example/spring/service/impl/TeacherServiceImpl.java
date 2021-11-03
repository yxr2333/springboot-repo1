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
}
