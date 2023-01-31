package com.example.blog.service;

import com.example.blog.common.BaseService;
import com.example.blog.entity.Category;
import com.example.blog.entity.PostCategoryRef;
import com.example.blog.entity.Tag;

import java.util.List;

/**
 * (PostCategoryRef)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface PostCategoryRefService extends BaseService<PostCategoryRef, Long> {

    void deleteByPostId(Long postId);

    Category findByPostId(Long postId);
}