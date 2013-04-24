package com.foo.jason.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.foo.jason.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
public class UserServiceTest {

	private UserService	userService;

	@Inject
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void testSaveUser() {
		User user = new User("abc", "def");
		assertNull(user.getUserId());
		userService.saveUser(user);
		assertNotNull(user.getUserId());
		assertNotNull(userService.getUserById(user.getUserId()));
		userService.deleteUserById(user.getUserId());
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void testDeleteUserById() {
		User user = userService.getUserById(2);
		userService.deleteUserById(2);
		assertNull(userService.getUserById(2));
		userService.saveUser(user);
	}

	@Test
	public void testGetUserById() {
		assertEquals(new User(1, "Jason", "Statham"), userService.getUserById(1));
	}

	@Test
	public void testGetListUsers() {
		ArrayList<User> usersList = userService.getListUsers();
		assertEquals(new User(1, "Jason", "Statham"), usersList.get(0));
		assertEquals(new User(2, "Jason", "Bourne"), usersList.get(1));
	}
}
