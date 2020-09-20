package com.shiro.springbootjspshiro.service;

import com.shiro.springbootjspshiro.entity.User;

/**
 * Author： yyhuang
 * Date：20
 */
public interface UserService {

    /**
     * @description: 用户注册
     * @author: yyhuang
     * @date: 2020/09/20
     */
    void register(User user);
    /**
     *  @description: 查找用户信息（根据用户名）
     *  @author: yyhuang
     *  @date: 2020/09/20
     */
    User findByusername(String username);
}
