package com.shiro.springbootjspshiro.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.shiro.springbootjspshiro.dao.UserDAO;
import com.shiro.springbootjspshiro.entity.User;
import com.shiro.springbootjspshiro.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 用户实现类
 * @author: yyhuang
 * @date: 2020/09/20
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        /**
         *  @description: 明文密码进行MD5 + saly + hash散列
         *                 randomString(String str,int length):String 从str中随机产生指定长度的字符串(所有字符来源于str）
         *  @author: yyhuang
         *  @date: 2020/09/20
         */

        String s = RandomUtil.randomString(IdUtil.simpleUUID(),8);
        user.setSalt(s);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), s,1024);
        user.setPassword(md5Hash.toHex());
        userDAO.save(user);
    }

    @Override
    public User findByusername(String username) {
        return userDAO.findByusername(username);
    }
}
