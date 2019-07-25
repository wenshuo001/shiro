package com.example.shiro.shiro.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "ok";
    }
    @RequestMapping(value = "/testThymeleaf")
    public String testThymeleaf(Model model) {
        //把数据存入model
        model.addAttribute("test", "测试Thymeleaf");
        //返回test.html
        return "test";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        //把数据存入model
        model.addAttribute("test", "添加用户页面");
        //返回test.html
        return "/user/add";
    }

    @RequestMapping(value = "/update")
    public String update(Model model) {
        //把数据存入model
        model.addAttribute("test", "修改用户页面");
        //返回test.html
        return "/user/update";
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }


    /**
     * 首先通过前端页面的form表单提交，在Controller请求处理层获取了form表单中的账号密码，
     * 然后获取当前用户的Subject对象，执行了Subject的login方法进行登录操作
     * 并将账号密码封装进Token对象，作为参数传入。而后面设置了认证需要的Realm类，该Realm类继承了AuthenticatingRealm父类，
     * 实现了doGetAuthenticationInfo方法，在doGetAuthenticationInfo方法中获取用户的账号密码，在做完一些校验后，
     * 传递给了SimpleAuthenticationInfo，并返回出去：
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(String username, String password, Model model) {
        System.out.printf("username :" + username);
        //1、获取 Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //3、执行登录方法
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
            //登录失败，用户名称不存在
            model.addAttribute("msg", "用户名称不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //登录失败，密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }
}
