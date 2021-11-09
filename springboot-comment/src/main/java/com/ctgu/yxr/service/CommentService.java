package com.ctgu.yxr.service;

import com.ctgu.yxr.entity.Comment;
import com.ctgu.yxr.exception.DataNotFoundException;

import java.util.List;

public interface CommentService {

    /**
     * 获取所有的评论
     * @return 所有的评论
     */
    List<Comment> getAll();

    /**
     * 根据id查询评论
     * @param id id
     * @return 评论
     * @throws DataNotFoundException 不存在
     */
    Comment getOne(Integer id) throws DataNotFoundException;

    /**
     * 发表评论
     * @param comment 评论内容
     * @return 保存的评论
     */
    Comment addOne(Comment comment) throws DataNotFoundException;
}
