package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.blog.dao.CategoryDao;
import com.example.blog.entity.Category;
import com.example.blog.entity.PostCategoryRef;
import com.example.blog.dao.PostCategoryRefDao;
import com.example.blog.entity.PostCategoryRef;
import com.example.blog.entity.Tag;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PostCategoryRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * (PostCategoryRef)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("postCategoryRefService")
public class PostCategoryRefServiceImpl implements PostCategoryRefService {
    @Autowired
    private PostCategoryRefDao postCategoryRefDao;
    @Autowired
    private CategoryService categoryService;


    @Override
    public BaseMapper<PostCategoryRef> getRepository() {
        return postCategoryRefDao;
    }

    @Override
    public void deleteByPostId(Long postId) {
        LambdaQueryWrapper<PostCategoryRef> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostCategoryRef::getPostId, postId);
        postCategoryRefDao.delete(queryWrapper);
    }


    @Override
    public Category findByPostId(Long postId) {
        LambdaQueryWrapper<PostCategoryRef> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostCategoryRef::getPostId, postId);
        List<PostCategoryRef> postCategoryRefs = postCategoryRefDao.selectList(queryWrapper);
        if(postCategoryRefs == null || postCategoryRefs.size() == 0) {
            return null;
        }
        List<Long> cateIds = postCategoryRefs.stream().map(p -> p.getCateId()).collect(Collectors.toList());
        List<Category> categoryList =  categoryService.findByBatchIds(cateIds);
        if(categoryList != null && categoryList.size() > 0) {
            return categoryList.get(0);
        }
        return null;
    }
}