package com.foo.jason.dao;

import java.util.ArrayList;
import com.foo.jason.entity.User;

public interface UserDao {

	void saveUser(User user);

	void deleteUserById(int id);

	User getUserById(int id);

	ArrayList<User> getListUsers();

}