package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (PostCategoryRef)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("post_category_ref")
public class PostCategoryRef implements Serializable {
    private static final long serialVersionUID = -85842342397954247L;
    /**
    * 文章ID
    */
    private Long postId;
    /**
    * 分类ID
    */
    private Long cateId;
    /**
    * ID
    */
    @TableId(type = IdType.AUTO)
    private Long id;



}