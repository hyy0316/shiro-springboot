package com.shiro.springbootjspshiro.dao;

import com.shiro.springbootjspshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author： yyhuang
 * Date：20
 */
@Mapper
public interface UserDAO {
    void save(User user);
    User findByusername(String username);
}
