package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Category;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Category)table database access layer
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface CategoryDao extends BaseMapper<Category> {

    List<Category> findAllWithCount();


}