package com.shiro.springbootjspshiro.controller;

import com.shiro.springbootjspshiro.entity.User;
import com.shiro.springbootjspshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 用户控制器
 * @author: yyhuang
 * @date: 2020/09/20
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserService userService;

    /**
     *  @description: 需要处理身份认证的登录  接口
     *  @author: yyhuang
     *  @date: 2020/09/20
     */
    @RequestMapping("login")
    public String longin(String username, String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建token 并判断是否认证成功
        try {
            subject.login(new UsernamePasswordToken(username,password));
            return "redirect:/index.jsp";
        }catch (UnknownAccountException e ){
            e.printStackTrace();
            System.out.println("用户名错误！");
        }catch (IncorrectCredentialsException e ){
            e.printStackTrace();
            System.out.println("密码错误！");
        }
        return  "redirect:/login.jsp";
    }

    /**
     *  @description: 退出登录
     *  @author: yyhuang
     *  @date: 2020/09/20 
     */
    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }
    /**
     *  @description: 注册
     *  @author: yyhuang
     *  @date: 2020/09/20 
     */
    @RequestMapping("register")
    public String register(User user){
        try {
            userService.register(user);
            return  "redirect:/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return  "redirect:/register.jsp";
        }
    }

}
