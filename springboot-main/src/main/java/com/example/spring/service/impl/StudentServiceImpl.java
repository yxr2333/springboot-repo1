package com.example.spring.service.impl;

import com.example.spring.dao.SmallClassDao;
import com.example.spring.dao.StudentDao;
import com.example.spring.dao.TeacherDao;
import com.example.spring.dao.UtilDao;
import com.example.spring.entity.Student;
import com.example.spring.exception.AlreadyHaveData;
import com.example.spring.exception.DataBaseDataError;
import com.example.spring.service.StudentSerivce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 22:01 2021-11-02
*/
@Service(value = "studentService")
@Transactional(rollbackFor = {})
public class StudentServiceImpl implements StudentSerivce {

    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;
    @Resource
    private SmallClassDao smallClassDao;
    @Resource
    private UtilDao utilDao;

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }
    @Override
    public Student getOne(Integer id){
        return studentDao.findById(id).get();
    }

    @Override
    public Student addOne(Student student){
        return studentDao.save(student);
    }

    @Override
    public Student updateOne(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void deleteOne(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void addTeacher(Integer teacherId, Integer studentId) {
        studentDao.addTeacher(teacherId,studentId);
        teacherDao.addStudent(teacherId,studentId);
    }

    /**
     * 给学生添加班级
     *
     * @param studentId 学生id
     * @param classId   班级id
     */
    @Override
    public void addClass(Integer studentId, Integer classId) throws Exception {
        if(utilDao.checkClassStudent(studentId,classId) == 0 && utilDao.checkStudentClass(studentId,classId) == 0 ){
            studentDao.addClass(studentId,classId);
            smallClassDao.addStudent(classId,studentId);
        }else if(utilDao.checkClassStudent(studentId,classId) > 0 && utilDao.checkStudentClass(studentId,classId) > 0 ){
            throw new AlreadyHaveData("已经存在此数据，无需重复添加");
        }else{
            throw new DataBaseDataError("班级和学生信息不同步，请检查数据库");
        }
    }
}
