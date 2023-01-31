package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.blog.entity.Category;
import com.example.blog.dao.CategoryDao;
import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Category)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    @Override
    public BaseMapper<Category> getRepository() {
        return categoryDao;
    }

    @Override
    public Category findByCateName(String cateName) {
        LambdaQueryWrapper<Category> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Category::getCateName, cateName);
        return categoryDao.selectOne(queryWrapper);
    }

    @Override
    public List<Category> findAllWithCount() {
        return categoryDao.findAllWithCount();
    }


}