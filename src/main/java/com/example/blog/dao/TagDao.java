package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Tag;
import java.util.List;

/**
 * @author JingxuanWei
 * @since 2023/02/10
 */
public interface TagDao extends BaseMapper<Tag> {
    List<Tag> findAllWithCount();
}