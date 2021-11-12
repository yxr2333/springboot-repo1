package com.example.web.springbootweb.service;

import com.example.web.springbootweb.dao.SlideShowDao;
import com.example.web.springbootweb.entity.SlideShow;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;

import java.util.List;

/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 20:44
**/

public interface SlideShowService {
    /**
     * 获取所有的轮播图数据
     * @return 所有的轮播图数据
     */
    List<SlideShow> getAll();

    /**
     * 根据id获取轮播图数据
     * @param id 编号
     * @return 数据
     * @throws DataNotFoundException 数据不存在
     */
    SlideShow getOneById(Integer id) throws DataNotFoundException;

    /**
     * 添加轮播图
     * @param slideShow 轮播图数据
     * @return 保存的数据
     */
    SlideShow addOne(SlideShow slideShow);

    /**
     * 更改轮播图数据
     * @param slideShow 轮播图数据
     * @return 更新的数据
     * @throws IdNotFoundException 编号没找到
     */
    SlideShow updateOne(SlideShow slideShow) throws IdNotFoundException;

    /**
     * 删除轮播图数据
     * @param id 编号
     * @throws DataNotFoundException 不存在
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
