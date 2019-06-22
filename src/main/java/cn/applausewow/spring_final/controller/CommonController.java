package cn.applausewow.spring_final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommonController {

    //重定向登录界面
    @RequestMapping(value = {"login", "/"})
    public String logIn(){return "login";}

    //重定向注册界面
    @RequestMapping("/register")
    public String register(){return "register";}

    @RequestMapping("/index")
    public String index(){return "index";}
}
