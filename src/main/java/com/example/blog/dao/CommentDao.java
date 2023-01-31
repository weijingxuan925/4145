package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Category;
import com.example.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Comment)table database access layer
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface CommentDao extends BaseMapper<Comment>  {


}