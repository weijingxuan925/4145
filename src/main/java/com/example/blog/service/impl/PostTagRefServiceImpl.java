package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.blog.dao.TagDao;
import com.example.blog.entity.PostTagRef;
import com.example.blog.dao.PostTagRefDao;
import com.example.blog.entity.Tag;
import com.example.blog.service.PostTagRefService;
import com.example.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * (PostTagRef)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("postTagRefService")
public class PostTagRefServiceImpl implements PostTagRefService {
    @Autowired
    private PostTagRefDao postTagRefDao;
    @Autowired
    private TagService tagService;

    @Override
    public BaseMapper<PostTagRef> getRepository() {
        return postTagRefDao;
    }

    @Override
    public void deleteByPostId(Long postId) {
        LambdaQueryWrapper<PostTagRef> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostTagRef::getPostId, postId);
        postTagRefDao.delete(queryWrapper);
    }

    @Override
    public List<Tag> findByPostId(Long postId) {
        LambdaQueryWrapper<PostTagRef> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PostTagRef::getPostId, postId);
        List<PostTagRef> postTagRefs = postTagRefDao.selectList(queryWrapper);
        if(postTagRefs == null || postTagRefs.size() == 0) {
            return new ArrayList<>();
        }
        List<Long> tagIds = postTagRefs.stream().map(p -> p.getTagId()).collect(Collectors.toList());
        return tagService.findByBatchIds(tagIds);
    }
}