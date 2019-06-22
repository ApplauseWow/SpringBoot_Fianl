package cn.applausewow.spring_final.service;

import cn.applausewow.spring_final.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	public List<User> getAllUsers();
	public Boolean checkUserInfo(String username, String password);
}
