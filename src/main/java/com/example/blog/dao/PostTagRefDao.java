package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.PostCategoryRef;
import com.example.blog.entity.PostTagRef;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PostTagRef)table database access layer
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface PostTagRefDao extends BaseMapper<PostTagRef>  {

}