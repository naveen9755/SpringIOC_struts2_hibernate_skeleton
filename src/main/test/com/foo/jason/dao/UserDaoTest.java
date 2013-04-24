package com.foo.jason.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.foo.jason.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext.xml" })
@Transactional
public class UserDaoTest {

	private UserDao	userDao;

	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Test
	public void testSaveUser() {
		User user = new User("abc", "def");
		assertNull(user.getUserId());
		userDao.saveUser(user);
		assertNotNull(user.getUserId());
		assertNotNull(userDao.getUserById(user.getUserId()));
	}

	@Test
	public void testDeleteUserById() {
		userDao.deleteUserById(2);
		assertNull(userDao.getUserById(2));
	}

	@Test
	public void testGetUserById() {
		assertEquals(new User(1, "Jason", "Statham"), userDao.getUserById(1));
	}

	@Test
	public void testGetListUsers() {
		ArrayList<User> usersList = userDao.getListUsers();
		assertEquals(new User(1, "Jason", "Statham"), usersList.get(0));
		assertEquals(new User(2, "Jason", "Bourne"), usersList.get(1));
	}
}
