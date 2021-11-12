package com.example.web.springbootweb.service;


import com.example.web.springbootweb.entity.Link;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;

import java.util.List;

/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 19:58
**/
public interface LinkService {

    /**
     * 获取所有的链接
     * @return 所有的链接
     */
    List<Link> getAll();

    /**
     * 根据id获取链接
     * @param id 链接编号
     * @return 链接信息
     * @throws DataNotFoundException 信息不存在
     */
    Link getOne(Integer id) throws DataNotFoundException;

    /**
     * 添加一个链接
     * @param link 链接信息
     * @return 保存后的链接的信息
     */
    Link addOne(Link link);

    /**
     * 修改一个链接
     * @param link 链接信息
     * @return 修改后的链接的信息
     * @throws IdNotFoundException 未找到被修改链接的id
     */
    Link updateOne(Link link) throws IdNotFoundException;

    /**
     * 根据id删除链接
     * @param id 被删除链接的id
     * @throws DataNotFoundException 被删除的链接不存在（非法id）
     */
    void deleteOne(Integer id) throws DataNotFoundException;
}
