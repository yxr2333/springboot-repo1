package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.TeacherDao;
import com.example.web.springbootweb.entity.Teacher;
import com.example.web.springbootweb.exception.DataAlreadyExsitException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 20:29 2021/11/5
 */
@Service(value = "teacherService")
@Transactional(rollbackFor = {})
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    /**
     * 获取所有报名的小导师信息
     *
     * @return 所有报名的小导师列表
     */
    @Override
    public List<Teacher> getAll() {
        return teacherDao.findAll();
    }

    /**
     * 根据id查询报名小导师信息
     *
     * @param id 小导师id
     * @return 小导师信息
     * @exception DataNotFoundException 查询不到
     */
    @Override
    public Teacher getOne(Integer id) throws DataNotFoundException{
        Optional<Teacher> teacher = teacherDao.findById(id);
        if(!teacher.isPresent()){
            throw new DataNotFoundException("信息不存在");
        }else{
            return teacher.get();
        }
    }

    /**
     * 报名
     *
     * @param teacher 报名信息
     * @return 存储到数据库中的信息
     * @throws DataAlreadyExsitException 学号已存在
     */
    @Override
    public Teacher addOne(Teacher teacher) throws DataAlreadyExsitException{
        String number = teacher.getNumber();
        Integer sum = teacherDao.findByNumber(number);
        if(sum == 1){
            throw new DataAlreadyExsitException("学号出现重复，请确认学号是否正确");
        }else{
            return teacherDao.save(teacher);
        }
    }


    /**
     * 更新
     *
     * @param teacher 小导师信息
     * @return 更新后的小导师信息
     */
    @Override
    public Teacher updateOne(Teacher teacher) throws DataNotFoundException{
        Integer id = teacher.getId();
        Optional<Teacher> teacherDaoById = teacherDao.findById(id);
        if(!teacherDaoById.isPresent()){
            throw new DataNotFoundException("该小导师信息不存在，无法更改");
        }else{
            return teacherDao.save(teacher);

        }
    }

    /**
     * 根据id删除小导师信息
     *
     * @param id 被删除的小导师id
     * @throws DataNotFoundException 小导师信息未找到，无法更改
     */
    @Override
    public void deleteOne(Integer id) throws DataNotFoundException {
        Optional<Teacher> teacher = teacherDao.findById(id);
        if(!teacher.isPresent()){
            throw new DataNotFoundException("不存在该导师，无法删除");
        }else{
            teacherDao.deleteById(id);
        }
    }
}
