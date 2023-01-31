package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (Category)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("category")
public class Category implements Serializable {
    private static final long serialVersionUID = 913130834313085622L;
    /**
    * ID
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 分类名称
    */
    private String cateName;

    @TableField(exist = false)
    private Integer count;

}