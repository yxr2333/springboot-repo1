package com.ctgu.yxr.service;

import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;

import java.security.NoSuchAlgorithmException;
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


    User getOneByName(String name);
    /**
     * 注册新用户
     * @param user 用户信息
     * @return 存储后的信息
     * @throws NoSuchAlgorithmException xx
     */
    User addOne(User user) throws NoSuchAlgorithmException;

    /**
     * 登录
     * @param userName 用户名
     * @param pwd 密码
     * @return 是否成功
     */
    Boolean login(String userName,String pwd);
}
