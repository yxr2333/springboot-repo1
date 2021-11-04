package com.example.spring.service.impl;

import com.example.spring.dao.ClerkDao;
import com.example.spring.dao.SmallClassDao;
import com.example.spring.entity.Clerk;
import com.example.spring.entity.SmallClass;
import com.example.spring.service.ClerkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 19:26 2021/11/3
 */

@Service(value = "clerkService")
@Transactional(rollbackFor = {})
public class ClerkServiceImpl implements ClerkService {
    @Resource
    private ClerkDao clerkDao;
    @Resource
    private SmallClassDao smallClassDao;

    /**
     * 获取所有的干事列表
     *
     * @return 干事列表
     */
    @Override
    public List<Clerk> getAll() {
        return clerkDao.findAll();
    }

    /**
     * 根据id获取干事信息
     *
     * @param id 干事id
     * @return 对应的干事信息
     */
    @Override
    public Clerk getOne(Integer id) {
        return clerkDao.findById(id).get();
    }

    /**
     * 增加新的干事
     *
     * @param clerk 添加的干事信息
     * @return 保存到数据库中的干事信息
     */
    @Override
    public Clerk addOne(Clerk clerk) {
        return clerkDao.save(clerk);
    }

    /**
     * 修改干事信息
     *
     * @param clerk 修改的干事信息（需要包含id）
     * @return 修改后保存到数据库中的信息
     */
    @Override
    public Clerk updateOne(Clerk clerk) {
        return clerkDao.save(clerk);
    }

    /**
     * 根据id删除干事信息
     *
     * @param id 需要被删除的干事的id
     */
    @Override
    public void deleteOne(Integer id) {
        clerkDao.deleteById(id);
    }

    /**
     * 给干事添加班级
     *
     * @param clerkId 干事id
     * @param classId 班级id
     * @return: Clerk 修改后的干事信息
     */
    @Override
    public Clerk addClass(Integer clerkId, Integer classId) {
        clerkDao.addClass(clerkId,classId);
        smallClassDao.setClerk(classId,clerkId);
        return clerkDao.findById(clerkId).get();
    }
}
