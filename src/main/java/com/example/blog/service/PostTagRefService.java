package com.example.blog.service;

import com.example.blog.common.BaseService;
import com.example.blog.entity.PostTagRef;
import com.example.blog.entity.Tag;

import java.util.List;

/**
 * (PostTagRef)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface PostTagRefService extends BaseService<PostTagRef, Long> {

    void deleteByPostId(Long postId);

    List<Tag> findByPostId(Long postId);
}