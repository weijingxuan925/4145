package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.blog.dao.CommentDao;
import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Comment)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public BaseMapper<Comment> getRepository() {
        return commentDao;
    }

    @Override
    public List<Comment> findByCommentParent(Long commentParent) {
        LambdaQueryWrapper<Comment> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Comment::getCommentParent, commentParent);
        queryWrapper.orderByAsc(Comment::getId);
        return this.findAll(queryWrapper);
    }
}