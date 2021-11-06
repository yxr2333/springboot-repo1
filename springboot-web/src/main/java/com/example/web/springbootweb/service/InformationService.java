package com.example.web.springbootweb.service;

import com.example.web.springbootweb.entity.Information;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.DataScarcityException;
import com.example.web.springbootweb.exception.IdNotFoundException;

import java.util.List;

/**
 * @author Xinrui Yu
 * @date 2021-11-6 10:34
 *
 */
public interface InformationService {
    /**
     * 获取所有的通知信息
     * @return 所有的通知信息
     */
    List<Information> getAll();

    /**
     * 根据id查询通知信息
     * @param id 通知id
     * @return 通知的信息
     * @throws DataNotFoundException 未找到
     */
    Information getOne(Integer id) throws DataNotFoundException;


    /**
     * 添加通知
     * @param information 通知信息
     * @return 保存成功的信息
     * @throws DataScarcityException 数据信息不全
     */
    Information addOne(Information information) throws DataScarcityException;

    /**
     * 更新通知的内容
     * @param information 需要被修改的通知信息
     * @return 修改后的数据
     * @throws IdNotFoundException id字段不存在
     * @throws DataNotFoundException 不存在此数据
     */
    Information updateOne(Information information) throws IdNotFoundException,DataNotFoundException;


    /**
     * @param id 被删除的通知的id
     * @throws DataNotFoundException 数据不存在，不能删除
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
