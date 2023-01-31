package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.blog.entity.Category;
import com.example.blog.entity.User;
import com.example.blog.dao.UserDao;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (User)table service implementation class
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public BaseMapper<User> getRepository() {
        return userDao;
    }

    @Override
    public User findByUserName(String username) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(User::getUserName, username);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public User getDefaultUser() {
        List<User> userList = this.findAll();
        if (userList.size() == 0) {
            return createDefaultUser();
        }
        return userList.get(0);
    }

    private User createDefaultUser() {
        User user = new User();
        user.setUserName("flame");
        user.setUserDisplayName("flame");
        user.setUserAvatar("/static/images/avatar/avatar.png");
        user.setUserEmail("flame@gmail.com");
        user.setUserPass("123456");
        user.setUserDesc("Hello world!");
        this.insert(user);
        return user;
    }
}