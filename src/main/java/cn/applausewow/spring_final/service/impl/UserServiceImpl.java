package cn.applausewow.spring_final.service.impl;


import cn.applausewow.spring_final.bean.User;
import cn.applausewow.spring_final.dao.UserDao;
import cn.applausewow.spring_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public Boolean checkUserInfo(String username, String password) {
		User user = userDao.getUserByUserName(username);
		if(user == null) return false;
		else return password.equals(user.getPasswd());
	}
}
