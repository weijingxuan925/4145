package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.blog.entity.Tag;
import com.example.blog.dao.TagDao;
import com.example.blog.entity.User;
import com.example.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tag)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public BaseMapper<Tag> getRepository() {
        return tagDao;
    }

    @Override
    public Tag findByTagName(String tagName) {
        LambdaQueryWrapper<Tag> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Tag::getTagName, tagName);
        return tagDao.selectOne(queryWrapper);
    }

    @Override
    public List<Tag> findAllWithCount() {
        return tagDao.findAllWithCount();
    }


}