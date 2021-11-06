package com.example.web.springbootweb.service;

import com.example.web.springbootweb.entity.Information;

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
}
