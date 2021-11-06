package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.InformationDao;
import com.example.web.springbootweb.entity.Information;
import com.example.web.springbootweb.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
}
