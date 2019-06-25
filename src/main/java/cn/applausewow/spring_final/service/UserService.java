package cn.applausewow.spring_final.service;

import cn.applausewow.spring_final.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
	public List<User> getAllUsers();
	public Boolean checkUserInfo(String username, String password);
	public User showUserByUserName(String username);
	public Boolean existUser(String username);
	public Boolean Register(User user);
	public Boolean modifySelfInfo(User user);
}
