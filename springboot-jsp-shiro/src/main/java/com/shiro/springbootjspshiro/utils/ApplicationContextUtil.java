package com.shiro.springbootjspshiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yyhuang
 * @date: 2020/09/20
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private  static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.context = applicationContext;
    }

    /**
     * @description: 根据bean名字获取工厂指定bean对象
     * @author: yyhuang
     * @date: 2020/09/20
     */

    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
