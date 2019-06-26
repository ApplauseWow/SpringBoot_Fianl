package cn.applausewow.spring_final.service.impl;


import cn.applausewow.spring_final.bean.User;
import cn.applausewow.spring_final.dao.UserDao;
import cn.applausewow.spring_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

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

	@Override
	public User showUserByUserName(String username) {
		return userDao.getUserByUserName(username);
	}

	@Override
	public Boolean Register(User user) {
		int row = userDao.insertUser(user);
		return row == 1;
	}

	@Override
	public Boolean existUser(String username) {
		User user = userDao.getUserByUserName(username);
		return user != null;
	}

	@Override
	public Boolean modifySelfInfo(User user) {
		return  userDao.updateUserByUserName(user) == 1;
	}

	@Override
	public Boolean deleteUserByUserId(Integer user_id) {
		return userDao.deleteUserByUserId(user_id) == 1;
	}
}
