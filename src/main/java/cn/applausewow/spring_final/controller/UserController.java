package cn.applausewow.spring_final.controller;


import cn.applausewow.spring_final.bean.User;
import cn.applausewow.spring_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/allUsers")
    @ResponseBody // 可以当接口使用，重新生成一个页面返回数据
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	//登录验证
	@RequestMapping("/checkInfo")
	public String checkUserInfo(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpSession httpSession) {
		if (userService.checkUserInfo(username, password)) {
			//验证正确，进入首页
			httpSession.setAttribute("username", username);
			return "index";
		} else {
			//验证失败，跳转至登录界面
			httpSession.setAttribute("msg", "用户名密码错误");
			return "redirect:/login";
		}

	}


}
