package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Post)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("post")
public class Post implements Serializable {
    private static final long serialVersionUID = 867647990995346254L;
    /**
    * ID
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 内容
    */
    private String postContent;
    /**
    * 状态，1已发布，0草稿
    */
    private Integer postStatus;
    /**
    * 摘要
    */
    private String postSummary;
    /**
    * 缩略图
    */
    private String postThumbnail;
    /**
    * 标题
    */
    private String postTitle;
    /**
    * 访问量
    */
    private Long postViews;
    /**
    * 创建时间
    */
    private Date createTime;


    /**
     * 分类
     */
    @TableField(exist = false)
    private Category category;
}