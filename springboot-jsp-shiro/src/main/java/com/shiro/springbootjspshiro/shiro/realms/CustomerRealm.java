package com.shiro.springbootjspshiro.shiro.realms;

import cn.hutool.core.util.StrUtil;
import com.shiro.springbootjspshiro.entity.User;
import com.shiro.springbootjspshiro.service.UserService;
import com.shiro.springbootjspshiro.utils.ApplicationContextUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * @description: 客户realm
 * @author: yyhuang
 * @date: 2020/09/19
 */
public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("********************************");
        //获取你的身份信息
        String principal = (String) authenticationToken.getPrincipal();
        /**
         *  @description: 在工厂中获取对象
         *  @author: yyhuang
         *  @date: 2020/09/20
         */
        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        System.out.println(userService);
        User user = userService.findByusername(principal);
        if(!ObjectUtils.isEmpty(user)){
            return  new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
//        if("xiaoming".equals(principal)){
//            System.out.println("身份通过认证，即用户名正确！！");
//            return  new SimpleAuthenticationInfo(principal,"123",this.getName());
//        }

       return null;
    }
}
