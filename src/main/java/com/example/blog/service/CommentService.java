package com.example.blog.service;

import com.example.blog.common.BaseService;
import com.example.blog.entity.Comment;

import java.util.List;

/**
 * (Comment)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface CommentService extends BaseService<Comment, Long> {

    List<Comment> findByCommentParent(Long commentParent);

}