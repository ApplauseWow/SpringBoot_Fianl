package cn.applausewow.spring_final.controller;


import cn.applausewow.spring_final.bean.User;
import cn.applausewow.spring_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
			httpSession.setAttribute("user", userService.showUserByUserName(username));
			return "index";
		} else {
			//验证失败，跳转至登录界面
			httpSession.setAttribute("msg", "用户名密码错误");
			return "redirect:/login";
		}

	}

	@RequestMapping("/register")
	public String register(HttpSession httpSession ,@RequestParam(value = "username")String username, @RequestParam(value = "name")String name, @RequestParam(value = "location")String location, @RequestParam(value = "password")String password, @RequestParam(value = "job")String job){
		if (!userService.existUser(username)){
			User user = new User();
			user.setUser_name(username);
			user.setPasswd(password);
			user.setJob(job);
			user.setLocation(location);
			user.setName(name);
			if(userService.Register(user)){
				user = userService.showUserByUserName(username);
				httpSession.setAttribute("user", user);
				return "index";
			}else {
				httpSession.setAttribute("msg", "注册失败重新注册");
				return "register";
			}

		}else {
			System.out.println("fail to register!");
			httpSession.setAttribute("msg", "用户名已存在");
			return "register";
		}

	}

	@ResponseBody
	@RequestMapping("/modifySelf")
	public Boolean modifySelfInfo(HttpServletRequest httpServletRequest, @RequestParam(value = "userId")Integer user_id , @RequestParam(value = "name")String name , @RequestParam(value = "username")String username, @RequestParam(value = "password")String password, @RequestParam(value = "job")String job, @RequestParam(value = "location")String location){
		User user = new User();
		user.setUser_id(user_id);
		user.setUser_name(username);
		user.setPasswd(password);
		user.setName(name);
		user.setJob(job);
		user.setLocation(location);
		return userService.modifySelfInfo(user);
	}

	@RequestMapping("/showUserByUserName")
	public Map<String, User> showUserByUserName(@RequestParam(value = "") String username){
		Map<String, User> map = new HashMap<>();
		map.put("user", userService.showUserByUserName(username));
		return map;
	}

}
