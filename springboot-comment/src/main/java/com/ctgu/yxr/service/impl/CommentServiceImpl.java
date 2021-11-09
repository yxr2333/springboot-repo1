package com.ctgu.yxr.service.impl;

import com.ctgu.yxr.dao.CommentDao;
import com.ctgu.yxr.dao.UserDao;
import com.ctgu.yxr.entity.Comment;
import com.ctgu.yxr.entity.User;
import com.ctgu.yxr.exception.DataNotFoundException;
import com.ctgu.yxr.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service(value = "commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;
    @Resource
    private UserDao userDao;
    /**
     * 获取所有的评论
     *
     * @return 所有的评论
     */
    @Override
    public List<Comment> getAll() {
        return commentDao.findAll();
    }

    /**
     * 根据id查询评论
     *
     * @param id id
     * @return 评论
     * @throws DataNotFoundException 不存在
     */
    @Override
    public Comment getOne(Integer id) throws DataNotFoundException {
        if(!commentDao.findById(id).isPresent()){
            throw new DataNotFoundException("评论不存在，请检查信息是否有误！");
        }else{
            return commentDao.findById(id).get();
        }
    }

    /**
     * 发表评论
     *
     * @param comment 评论内容
     * @return 保存的评论
     */
    @Override
    public Comment addOne(Comment comment) throws DataNotFoundException {
        Optional<User> optionalUser = userDao.findById(comment.getUser().getId());
        if(!optionalUser.isPresent()){
            throw new DataNotFoundException("不存在此评论人的信息！");
        }else{
            comment.setUser(optionalUser.get());
            return commentDao.save(comment);
        }

    }
}
