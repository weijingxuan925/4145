package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)entity class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 743829587028356546L;
    /**
    * ID
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 头像
    */
    private String userAvatar;
    /**
    * 个人签名
    */
    private String userDesc;
    /**
    * 昵称
    */
    private String userDisplayName;
    /**
    * 邮箱
    */
    private String userEmail;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码：md5加盐多次
    */
    private String userPass;


}