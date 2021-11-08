package com.ctgu.yxr.service.impl;

import com.ctgu.yxr.dao.UserDao;
import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;
import com.ctgu.yxr.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;
    /**
     * 获取所有的用户列表
     *
     * @return 所有的用户列表
     */
    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    @Override
    public User getOne(Integer id) throws DataNotFoundException {
        if(!userDao.findById(id).isPresent()){
            throw new DataNotFoundException("不存在此用户，请检查用户信息是否有误！");
        }else{
            return userDao.findById(id).get();
        }
    }
}
