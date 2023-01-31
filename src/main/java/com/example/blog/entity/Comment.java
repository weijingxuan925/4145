package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Comment)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 914603192691796100L;
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 内容
     */
    private String commentContent;
    /**
     * 上级评论ID
     */
    private Long commentParent;
    /**
     * 文章ID
     */
    private Long postId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 评论人名称
     */
    private String authorName;
    /**
     * 评论人邮箱
     */
    private String authorEmail;

    /**
     * 评论人头像
     */
    private String authorAvatar;

    /**
     * 文章
     */
    @TableField(exist = false)
    private Post post;

    /**
     * 子评论列表
     */
    @TableField(exist = false)
    private List<Comment> childCommentList;
}