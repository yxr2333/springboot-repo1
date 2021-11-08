package com.ctgu.yxr.service.impl;

import com.ctgu.yxr.dao.UserDao;
import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;
import com.ctgu.yxr.service.UserService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    /**
     * 注册新用户
     *
     * @param user 用户信息
     * @return 存储后的信息
     */
    @Override
    public User addOne(User user) throws NoSuchAlgorithmException {
        String password = user.getPassword();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(password.getBytes());
        System.out.println("加密后的字符串：" + encode);
        user.setPassword(encode);
        return userDao.save(user);
    }


    @Override
    public User getOneByName(String name) {
        return userDao.getUserByName(name);
    }

    /**
     * 登录
     *
     * @param userName 用户名
     * @param pwd      密码
     * @return 是否成功
     */
    @Override
    public Boolean login(String userName, String pwd) {
        String pwdByName = userDao.getPwdByName(userName);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        String decode = null;
        try {
            decode = new String(base64Decoder.decodeBuffer(pwdByName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("pwd:" + pwd);
        System.out.println("decode" + decode);
        if(decode.equals(pwd)){
            return true;
        }else {
            return false;
        }
    }
}
