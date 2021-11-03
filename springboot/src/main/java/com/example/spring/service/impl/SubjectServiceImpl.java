package com.example.spring.service.impl;

import com.example.spring.dao.SubjectDao;
import com.example.spring.entity.Subject;
import com.example.spring.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:27 2021/11/3
 */
@Service("subjectService")
@Transactional(rollbackFor = {})
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectDao subjectDao;

    @Override
    public List<Subject> getAll() {
        return subjectDao.findAll();
    }

    /**
     * @param id 学科id
     * @return 学科信息
     */
    @Override
    public Subject getOne(Integer id) {
        return subjectDao.findById(id).get();
    }

    /**
     * @param subject 学科信息
     * @return 保存到数据库中的学科信息
     */
    @Override
    public Subject addOne(Subject subject) {
        return subjectDao.save(subject);
    }

    /**
     * @param subject 需要修改的学科信息（要包含id）
     * @return 数据库中修改后的学科信息
     */
    @Override
    public Subject updateOne(Subject subject) {
        return subjectDao.save(subject);
    }

    /**
     * @param id 被删除的学科的id
     */
    @Override
    public void deleteOne(Integer id) {
        subjectDao.deleteById(id);
    }
}
