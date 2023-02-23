package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @apiNote tdas
 * @author JingxuanWei
 * @since 2023/02/10
 */
public interface PostDao extends BaseMapper<Post> {
    List<Post> findByCategoryId(@Param("categoryId") Long categoryId, @Param("keywords") String keywords, Page page);
    List<Post> findByTagId(@Param("tagId") Long tagId, @Param("keywords") String keywords, Page page);
}