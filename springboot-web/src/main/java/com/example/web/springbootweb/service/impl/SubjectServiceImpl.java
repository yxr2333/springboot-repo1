package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.SubjectDao;
import com.example.web.springbootweb.entity.Subject;
import com.example.web.springbootweb.exception.DataAlreadyExistException;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Xinrui Yu
 * @date 2021-11-6 0:50
 */
@Service(value = "subjectService")
@Transactional(rollbackFor = {})
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectDao subjectDao;

    /**
     * 获取所有的学科信息
     *
     * @return 所有学科信息
     */
    @Override
    public List<Subject> getAll() {
        return subjectDao.findAll();
    }

    /**
     * 根据id查询学科信息
     *
     * @param id 学科id
     * @return 对应的学科信息
     * @throws DataNotFoundException 数据未找到
     */
    @Override
    public Subject getOne(Integer id) throws DataNotFoundException {
        Optional<Subject> subjectOptional = subjectDao.findById(id);
        if(!subjectOptional.isPresent()){
            throw new DataNotFoundException("不存在此学科信息，请检查学科编号是否有误！");
        }else{
            return subjectOptional.get();
        }
    }

    /**
     * 添加单个学科
     *
     * @param subject 学科信息
     * @return 保存后的学科信息
     * @throws DataAlreadyExistException 学科名字重复
     */
    @Override
    public Subject addOne(Subject subject) throws DataAlreadyExistException {
        Integer sum = subjectDao.findByName(subject.getName());
        if(sum == 1){
            throw new DataAlreadyExistException("学科名称重复，不可重复添加！");
        }else{
            return subjectDao.save(subject);
        }
    }

    /**
     * 更新学科的信息
     *
     * @param subject 学科信息（需要包含id）
     * @return 修改后的学科信息
     * @throws IdNotFoundException 未输入编号
     * @throws DataNotFoundException 输入的编号不存在
     */
    @Override
    public Subject updateOne(Subject subject) throws IdNotFoundException,DataNotFoundException {
        if(subject.getId() == null){
            throw new IdNotFoundException("未输入学科id，请重新检查输入的数据");
        }else if(!subjectDao.findById(subject.getId()).isPresent()){
            throw new DataNotFoundException("不存在此学科信息，请检查学科编号是否有误！");
        }else{
            return subjectDao.save(subject);

        }
    }
    // TODO: 2021/11/6 参考删除学科与学生和小导师时操作，修改、完善其他接口的操作
    /**
     * 根据id删除一个学科的信息
     * 需要同时删除该学科与学生和小导师之间的关联
     * @param id 被删除的学科的id
     * @throws DataNotFoundException 学科不存在
     */
    @Override
    public void deleteOne(Integer id) throws DataNotFoundException {
        Optional<Subject> subjectOptional = subjectDao.findById(id);
        if(!subjectOptional.isPresent()){
            throw new DataNotFoundException("不存在此学科的信息，无法进行删除");
        }else{
            subjectDao.deleteStudentKey(id);
            subjectDao.deleteTeacherKey(id);
            subjectDao.deleteById(id);
        }
    }
}
