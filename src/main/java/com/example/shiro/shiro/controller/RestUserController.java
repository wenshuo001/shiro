package com.example.shiro.shiro.controller;


import com.example.shiro.bean.BaseResponse;
import com.example.shiro.bean.ResultCode;
import com.example.shiro.bean.User;
import com.example.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shiro")
public class RestUserController {

    /**
     * 通过品牌id查询商品分类
     * @param bid
     * @return
     */
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public BaseResponse login(@RequestParam("username")String username,@RequestParam("password") String password) {

        System.out.printf("username :" + username);
        //1、获取 Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //3、执行登录方法
        String msg = "";
        try {
            subject.login(usernamePasswordToken);
            // if no exception, that's it, we're done!  如果没有异常，那就是了 我们完成了
            msg ="登录成功";
            return new BaseResponse().setResultCode(ResultCode.SUCCESS).setResultMsg(msg).setResultContent((User) subject.getPrincipal());
        } catch (UnknownAccountException e) {
            //登录失败，用户名称不存在
           // model.addAttribute("msg", "用户名称不存在");
            msg ="用户名称不存在";
            return new BaseResponse().setResultCode(ResultCode.BIZ_ERROR).setResultMsg(msg).setResultContent(null);
        } catch (IncorrectCredentialsException e) {
            //登录失败，密码错误
          //  model.addAttribute("msg", "密码错误");
            msg = "密码错误" ;
            return new BaseResponse().setResultCode(ResultCode.BIZ_ERROR).setResultMsg(msg).setResultContent(null);
        }

    }
 }
