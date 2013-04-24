package com.foo.jason.service;

import java.util.ArrayList;
import com.foo.jason.entity.User;

public interface UserService {

	void saveUser(User user);

	void deleteUserById(int id);

	User getUserById(int id);

	ArrayList<User> getListUsers();

}