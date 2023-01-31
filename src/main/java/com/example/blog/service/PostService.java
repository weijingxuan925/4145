package com.example.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.common.BaseService;
import com.example.blog.entity.Post;

/**
 * (Post)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface PostService extends BaseService<Post, Long> {


    /**
     * 根据分类查询
     *
     * @param categoryId
     * @param keywords
     * @return
     */
    Page<Post> findByCategoryId(Long categoryId, String keywords, Page<Post> page);

    /**
     * 根据标签查询
     *
     * @param tagId
     * @param keywords
     * @return
     */
    Page<Post> findByTagId(Long tagId, String keywords, Page<Post> page);

}