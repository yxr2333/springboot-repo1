package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.InformationDao;
import com.example.web.springbootweb.entity.Information;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.DataScarcityException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
* Created by IDEA
* @author Xinrui Yu
* @date 2021/11/6 10:42
**/
@Service(value = "informationService")
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationDao informationDao;
    /**
     * 获取所有的通知信息
     *
     * @return 所有的通知信息
     */
    @Override
    public List<Information> getAll() {
        return informationDao.findAll();
    }

    /**
     * 根据id查询通知信息
     *
     * @param id 通知id
     * @return 通知的信息
     * @throws DataNotFoundException 未找到
     */
    @Override
    public Information getOne(Integer id) throws DataNotFoundException {
        Optional<Information> informationOptional = informationDao.findById(id);
        if(!informationOptional.isPresent()){
            throw new DataNotFoundException("不存在此通知信息");
        }else{
            return informationOptional.get();
        }
    }

    /**
     * 添加通知
     *
     * @param information 通知信息
     * @return 保存成功的信息
     * @throws DataScarcityException 数据信息不全
     */
    @Override
    public Information addOne(Information information) throws DataScarcityException{
        if(information.getTitle() == null || information.getContent() == null || information.getPublishTime() == null){
            throw new DataScarcityException("数据信息不全，请检查标题、内容和时间是否有未填写的部分！");
        }else{
            return informationDao.save(information);
        }
    }

    /**
     * 更新通知的内容
     *
     * @param information 需要被修改的通知信息
     * @return 修改后的数据
     * @throws IdNotFoundException   id字段不存在
     * @throws DataNotFoundException 不存在此数据
     */
    @Override
    public Information updateOne(Information information) throws IdNotFoundException, DataNotFoundException {
        if(information.getId() == null){
            throw new IdNotFoundException("未找到编号属性，请检查输入的数据是否有误！");
        }else{
            if(!informationDao.findById(information.getId()).isPresent()){
                throw new DataNotFoundException("不存在此编号对应的数据，请检查编号是否有误！");
            }else{
                return informationDao.save(information);
            }
        }
    }

    /**
     * @param id 被删除的通知的id
     * @throws DataNotFoundException 数据不存在，不能删除
     */
    @Override
    public void deleteOne(Integer id) throws DataNotFoundException {
        if(!informationDao.findById(id).isPresent()){
            throw new DataNotFoundException("不存在此编号对应的数据，请检查编号是否有误！");
        }else{
            informationDao.deleteById(id);
        }
    }
}
