package com.example.web.springbootweb.service.impl;

import com.example.web.springbootweb.dao.LinkDao;
import com.example.web.springbootweb.entity.Link;
import com.example.web.springbootweb.exception.DataNotFoundException;
import com.example.web.springbootweb.exception.IdNotFoundException;
import com.example.web.springbootweb.service.LinkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;


/**
* created by IDEA
* @author Xinrui Yu
* @date 2021/11/12 19:59
**/
@Service(value = "linkService")
@Transactional(rollbackFor = {})
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkDao linkDao;

    /**
     * 获取所有的链接
     *
     * @return 所有的链接
     */
    @Override
    public List<Link> getAll() {
        return linkDao.findAll();
    }

    /**
     * 根据id获取链接
     *
     * @param id 链接编号
     * @return 链接信息
     * @throws DataNotFoundException 信息不存在
     */
    @Override
    public Link getOne(Integer id) throws DataNotFoundException {
        if(!linkDao.existsById(id)){
            throw new DataNotFoundException("不存在此链接的信息，请检查链接编号是否有误！");
        }else{
            return linkDao.findById(id).get();
        }
    }

    /**
     * 添加一个链接
     *
     * @param link 链接信息
     * @return 保存后的链接的信息
     */
    @Override
    public Link addOne(Link link) {
        return linkDao.save(link);
    }

    /**
     * 修改一个链接
     *
     * @param link 链接信息
     * @return 修改后的链接的信息
     * @throws IdNotFoundException 未找到被修改链接的id
     */
    @Override
    public Link updateOne(Link link) throws IdNotFoundException {
        if(link.getId() == null){
            throw new IdNotFoundException("未找到编号信息，请检查数据是否有误！");
        }else{
            return linkDao.save(link);
        }
    }

    /**
     * 根据id删除链接
     *
     * @param id 被删除链接的id
     * @throws DataNotFoundException 被删除的链接不存在（非法id）
     */
    @Override
    public void deleteOne(Integer id) throws DataNotFoundException {
        if(!linkDao.existsById(id)){
            throw new DataNotFoundException("不存在此数据，无法进行删除！");
        }else{
            linkDao.deleteById(id);
        }
    }
}
