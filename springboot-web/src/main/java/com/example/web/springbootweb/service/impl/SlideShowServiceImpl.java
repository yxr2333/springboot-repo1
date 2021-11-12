package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.SlideShowDao;
import com.example.web.springbootweb.entity.SlideShow;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.SlideShowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @date 2021/11/12 20:55 星期五
 */

@Service("slideShowService")
@Transactional(rollbackFor = {})
public class SlideShowServiceImpl implements SlideShowService {

    @Resource
    private SlideShowDao slideShowDao;

    /**
     * 获取所有的轮播图数据
     *
     * @return 所有的轮播图数据
     */
    @Override
    public List<SlideShow> getAll() {
        return slideShowDao.findAll();
    }

    /**
     * 根据id获取轮播图数据
     *
     * @param id 编号
     * @return 数据
     * @throws DataNotFoundException 数据不存在
     */
    @Override
    public SlideShow getOneById(Integer id) throws DataNotFoundException {
        if(!slideShowDao.existsById(id)){
            throw new DataNotFoundException("不存在此编号对应的数据，请检查编号是否有误！");
        }else{
            return slideShowDao.findById(id).get();
        }
    }

    /**
     * 添加轮播图
     *
     * @param slideShow 轮播图数据
     * @return 保存的数据
     */
    @Override
    public SlideShow addOne(SlideShow slideShow) {
        return slideShowDao.save(slideShow);
    }

    /**
     * 更改轮播图数据
     *
     * @param slideShow 轮播图数据
     * @return 更新的数据
     * @throws IdNotFoundException 编号没找到
     */
    @Override
    public SlideShow updateOne(SlideShow slideShow) throws IdNotFoundException {
        if(slideShow.getId() == null){
            throw new IdNotFoundException("未找到编号，请检查输入的数据是否有误");
        }else{
            return slideShowDao.save(slideShow);
        }
    }

    /**
     * 删除轮播图数据
     *
     * @param id 编号
     * @throws DataNotFoundException 不存在
     */
    @Override
    public void deleteOne(Integer id) throws DataNotFoundException {
        if(!slideShowDao.existsById(id)){
            throw new DataNotFoundException("编号对应的数据不存在，请检查编号是否有误！");
        }else{
            slideShowDao.deleteById(id);
        }
    }
}
