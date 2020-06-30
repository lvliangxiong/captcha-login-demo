package com.joey.learning.spring.service;

import com.joey.learning.spring.pojo.User;

/**
 * @Author: Joey
 * @Date: 20/03/2020 10:53 AM
 */
public interface UserService {
    public static final int USERNAME_PASSWORD_MISMATCHED = 1;
    public static final int CAPTCHA_WRONG = 2;

    User login(User u);
}
