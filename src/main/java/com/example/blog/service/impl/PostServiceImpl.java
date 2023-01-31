package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.Post;
import com.example.blog.dao.PostDao;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * (Post)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public BaseMapper<Post> getRepository() {
        return postDao;
    }

    @Override
    public Page<Post> findByCategoryId(Long categoryId, String keywords, Page<Post> page) {
        return page.setRecords(postDao.findByCategoryId(categoryId, keywords, page));
    }

    @Override
    public Page<Post> findByTagId(Long tagId, String keywords, Page<Post> page) {
        return page.setRecords(postDao.findByTagId(tagId, keywords, page));
    }
}