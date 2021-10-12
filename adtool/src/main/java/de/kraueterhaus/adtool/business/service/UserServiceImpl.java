package de.kraueterhaus.adtool.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.kraueterhaus.adtool.model.User;
import de.kraueterhaus.adtool.persistence.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public List<User> getUsers()
	{
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user)
	{
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public User getUser(int id)
	{
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void deleteUser(int id)
	{
		userDAO.deleteUser(id);
	}

}
