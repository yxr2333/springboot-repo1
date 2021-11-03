package com.example.spring.service.impl;

import com.example.spring.dao.SmallClassDao;
import com.example.spring.entity.SmallClass;
import com.example.spring.service.SmallClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:28 2021/11/3
 */
@Service(value = "smallClassService")
@Transactional(rollbackFor = {})
public class SmallClassServiceImpl implements SmallClassService {

    @Resource
    private SmallClassDao smallClassDao;
    /**
     *
     * @return List<SmallClass> 所有的班级列表
     */
    @Override
    public List<SmallClass> getAll() {
        return smallClassDao.findAll();
    }

    /**
     * @param id 班级id
     * @return 班级信息
     */
    @Override
    public SmallClass getOne(Integer id) {
        return smallClassDao.findById(id).get();
    }

    /**
     * @param smallClass 班级信息
     * @return 保存到数据库中的班级信息
     */
    @Override
    public SmallClass addOne(SmallClass smallClass) {
        return smallClassDao.save(smallClass);
    }

    /**
     * @param smallClass 需要修改的班级信息（要包含id）
     * @return 数据库中修改后的班级信息
     */
    @Override
    public SmallClass updateOne(SmallClass smallClass) {
        return smallClassDao.save(smallClass);
    }

    /**
     * @param id 被删除的班级的id
     */
    @Override
    public void deleteOne(Integer id) {
        smallClassDao.deleteById(id);
    }
}
