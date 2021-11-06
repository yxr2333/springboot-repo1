package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.StudentDao;
import com.example.web.springbootweb.entity.Student;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "studentService")
@Transactional(rollbackFor = {})
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 获取所有的学生信息
     *
     * @return 数据库中所有的学生信息
     */
    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    /**
     * 根据id查询学生信息
     *
     * @param id 学生id
     * @return 学生信息
     * @throws DataNotFoundException 学生信息未找到
     */
    @Override
    public Student getOne(Integer id) throws DataNotFoundException {
        Optional<Student> studentOptional = studentDao.findById(id);
        if(!studentOptional.isPresent()){
            throw new DataNotFoundException("不存在该学生信息，请检查编号是否有误！");
        }else{
            return studentOptional.get();
        }
    }

    /**
     * 添加一名学生
     *
     * @param student 学生信息
     * @return 保存到数据库中的学生信息
     * @throws DataAlreadyExistException 学号重复
     */
    @Override
    public Student addOne(Student student) throws DataAlreadyExistException {
        Integer sum = studentDao.findByNumber(student.getNumber());
        if(sum == 1){
            throw new DataAlreadyExistException("学号重复，请检查学号是否正确");
        }else{
            return studentDao.save(student);
        }
    }

    /**
     * 更新学生信息
     *
     * @param student 更新的学生信息
     * @return 更新后的学生信息
     * @throws DataNotFoundException 数据未找到
     * @throws IdNotFoundException 编号不存在
     */
    @Override
    public Student updateOne(Student student) throws DataNotFoundException, IdNotFoundException {
        if(student.getId() == null){
            throw new IdNotFoundException("未输入学生编号，请检查学生信息！");
        }else{
            if(!studentDao.findById(student.getId()).isPresent()){
                throw new DataNotFoundException("不存在此学生信息，无法进行修改");
            }else{
                return studentDao.save(student);
            }
        }
    }

    /**
     * 根据id删除学生信息
     *
     * @param id 学生id
     * @throws DataNotFoundException 数据不存在
     */
    @Override
    public void deleteOne(Integer id) throws DataNotFoundException {
        Optional<Student> studentOptional = studentDao.findById(id);
        if(!studentOptional.isPresent()){
            throw new DataNotFoundException("不存在该学生的信息，请检查编号是否有误！");
        }else{
            studentDao.deleteById(id);
        }
    }
}
