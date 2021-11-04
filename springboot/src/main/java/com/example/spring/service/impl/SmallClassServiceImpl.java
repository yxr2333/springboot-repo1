package com.example.spring.service.impl;

import com.example.spring.dao.*;
import com.example.spring.entity.SmallClass;
import com.example.spring.exception.AlreadyHaveData;
import com.example.spring.exception.DataBaseDataError;
import com.example.spring.service.SmallClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.rmi.CORBA.Util;
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
    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private ClerkDao clerkDao;
    @Resource
    private UtilDao utilDao;
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

    /**
     * 给班级添加学生
     *
     * @param studentId 学生id
     * @param classId   班级id
     */
    @Override
    public void addStudent(Integer studentId, Integer classId) throws Exception{
        if(utilDao.checkClassStudent(studentId,classId) == 0 && utilDao.checkStudentClass(studentId,classId) == 0 ){
            studentDao.addClass(studentId,classId);
            smallClassDao.addStudent(classId,studentId);
        }else if(utilDao.checkClassStudent(studentId,classId) > 0 && utilDao.checkStudentClass(studentId,classId) > 0 ){
            throw new AlreadyHaveData("已经存在此数据，无需重复添加");
        }else{
            throw new DataBaseDataError("班级和学生信息不同步，请检查数据库");
        }

    }

    /**
     * 给班级设置小导师
     *
     * @param classId   班级id
     * @param teacherId 小导师id
     */
    @Override
    public void setTeacher(Integer classId, Integer teacherId) {
        smallClassDao.setTeacher(classId,teacherId);
        teacherDao.addClass(teacherId,classId);
    }

    /**
     * 给班级设置干事
     *
     * @param classId 班级id
     * @param clerkId 干事id
     * @return: 修改后的班级信息
     */
    @Override
    public SmallClass setClerk(Integer classId, Integer clerkId) {
        clerkDao.addClass(clerkId,classId);
        smallClassDao.setClerk(classId,clerkId);
        return smallClassDao.findById(classId).get();
    }
}
