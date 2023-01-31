package com.example.blog.service;

import com.example.blog.common.BaseService;
import com.example.blog.entity.User;

/**
 * (User)table service interface
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
public interface UserService extends BaseService<User, Long> {

    User findByUserName(String username);

    User getDefaultUser();
}