package com.shiro.springbootjspshiro.config;


import com.shiro.springbootjspshiro.shiro.realms.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


/**
 * @description: 用来整合shiro的配置类
 * @author: yyhuang
 * @date: 2020/09/19
 */
@Configuration
public class ShiroConfig {
    /**
     *  @description: 1.创建shiroFilter  拦截所有的请求
     *  @author: yyhuang
     *  @date: 2020/09/19 
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统的受限资源
        //配置系统的公共资源
        HashMap<String, String> map = new HashMap<>();
        //authc 表示的是受限资源 ，请求这个资源需要认证和授权
        map.put("/index.jsp","authc");
//        map.put("index.jsp","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);


        return shiroFilterFactoryBean;
    }

    /**
     *  @description: 2.创建安全管理器
     *  @author: yyhuang
     *  @date: 2020/09/19 
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }

    /**
     *  @description: 3.创建自定义realm
     *  @author: yyhuang
     *  @date: 2020/09/19
     */
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm  = new CustomerRealm();
        return customerRealm;
    }

}
