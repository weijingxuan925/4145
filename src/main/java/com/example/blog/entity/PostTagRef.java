package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (PostTagRef)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("post_tag_ref")
public class PostTagRef implements Serializable {
    private static final long serialVersionUID = 728135051212018367L;
    /**
    * 文章ID
    */
    private Long postId;
    /**
    * 标签ID
    */
    private Long tagId;
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Long id;


}