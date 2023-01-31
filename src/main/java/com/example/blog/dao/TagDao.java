package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Category;
import com.example.blog.entity.PostTagRef;
import com.example.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Tag)table database access layer
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface TagDao extends BaseMapper<Tag> {
    List<Tag> findAllWithCount();


}