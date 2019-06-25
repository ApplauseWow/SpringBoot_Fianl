package cn.applausewow.spring_final.controller;

import cn.applausewow.spring_final.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    //转发登录界面
    @RequestMapping(value = {"login", "/"})
    public String logIn(){return "login";}

    //转发注册界面
    @RequestMapping("/signIn")
    public String register(){return "register";}

    @RequestMapping("/admin")
    public String admin(){return "manager";}
}
