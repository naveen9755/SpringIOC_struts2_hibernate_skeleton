package com.foo.jason.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.foo.jason.entity.User;
import com.foo.jason.service.UserService;

@Controller
@Scope("prototype")
public class IndexStruts {

	private static final Logger	logger		= Logger.getLogger(IndexStruts.class);
	private UserService			userService;
	private ArrayList<User>		usersList	= new ArrayList<User>();
	private String				lastName;
	private String				firstName;
	private Integer				userId;

	public String index() {
		logger.debug("index()");
		usersList = userService.getListUsers();
		return "SUCCESS";
	}

	@Autowired
	public IndexStruts(UserService userService) {
		super();
		this.userService = userService;
	}

	// @Inject
	// public void setUserService(UserService userService) {
	// this.userService = userService;
	// }

	public String addUser() throws ClassNotFoundException, SQLException {
		User e = new User(lastName, firstName);
		userService.saveUser(e);
		logger.debug("First name - Last name of the user :  " + firstName + " - " + lastName);
		return "SUCCESS";
	}

	public String deleteUser() {
		logger.debug("userId of the User to delete : " + userId);
		userService.deleteUserById(userId);
		return "SUCCESS";
	}

	public ArrayList<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<User> usersList) {
		this.usersList = usersList;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
