package com.foo.jason.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.foo.jason.dao.UserDao;
import com.foo.jason.entity.User;
import com.foo.jason.service.UserService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class UserServiceImpl implements UserService {

	private UserDao	userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	// @Inject
	// public void setUserDao(UserDao examenDao) {
	// this.userDao = examenDao;
	// }

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public ArrayList<User> getListUsers() {
		return userDao.getListUsers();
	}
}
