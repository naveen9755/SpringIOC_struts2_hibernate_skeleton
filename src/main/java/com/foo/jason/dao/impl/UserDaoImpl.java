package com.foo.jason.dao.impl;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.foo.jason.dao.UserDao;
import com.foo.jason.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager	entityManager;

	public void saveUser(User user) {
		entityManager.persist(user);
	}

	public void deleteUserById(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}

	public ArrayList<User> getListUsers() {
		Query query = entityManager.createQuery("from User");
		return Cast.castList(User.class, query.getResultList());
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}