package com.joey.learning.spring.service.impl;

import com.joey.learning.spring.mapper.UserMapper;
import com.joey.learning.spring.pojo.User;
import com.joey.learning.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Joey
 * @Date: 20/03/2020 10:54 AM
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.selByUsernameAndPassword(user);
    }
}
