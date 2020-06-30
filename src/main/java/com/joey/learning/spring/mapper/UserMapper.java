package com.joey.learning.spring.mapper;

import com.joey.learning.spring.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Joey
 * @Date: 20/03/2020 10:49 AM
 */
public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User selByUsernameAndPassword(User user);
}
