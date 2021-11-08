package com.ctgu.yxr.service;

import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;

import java.util.List;

public interface UserService {
    /**
     * 获取所有的用户列表
     * @return 所有的用户列表
     */
    List<User> getAll();

    /**
     * 根据id获取用户信息
     * @param id id
     * @return 用户信息
     * @throws DataNotFoundException 用户不存在
     */
    User getOne(Integer id) throws DataNotFoundException;
}
