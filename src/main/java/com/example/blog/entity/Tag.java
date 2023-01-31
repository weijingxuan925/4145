package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (Tag)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = 553785685773659508L;
    /**
    * ID
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 标签名称
    */
    private String tagName;

    @TableField(exist = false)
    private Integer count;

}