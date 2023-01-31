package com.example.blog.service;

import com.example.blog.common.BaseService;
import com.example.blog.entity.Category;
import com.example.blog.entity.Tag;

import java.util.List;

/**
 * (Tag)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface TagService extends BaseService<Tag, Long> {

    Tag findByTagName(String tagName);

    List<Tag> findAllWithCount();

}