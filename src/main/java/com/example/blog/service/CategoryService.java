package com.example.blog.service;

import com.example.blog.common.BaseService;
import com.example.blog.entity.Category;
import com.example.blog.entity.Tag;

import java.util.List;

/**
 * (Category)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface CategoryService extends BaseService<Category, Long> {

    Category findByCateName(String cateName);

    List<Category> findAllWithCount();
}