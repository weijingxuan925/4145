package com.example.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.PostCategoryRef;
import com.example.blog.entity.PostTagRef;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author JingxuanWei
 * @since 2023/02/10
 */
public interface PostTagRefDao extends BaseMapper<PostTagRef>  {
}