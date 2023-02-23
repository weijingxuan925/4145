package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Category;
import com.example.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @apiNote table database
 * @author JingxuanWei
 * @since 2023/02/10
 */
public interface CommentDao extends BaseMapper<Comment>  {
}