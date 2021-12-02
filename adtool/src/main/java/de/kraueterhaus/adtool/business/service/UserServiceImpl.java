package de.kraueterhaus.adtool.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.kraueterhaus.adtool.model.User;
import de.kraueterhaus.adtool.persistence.dao.UserDAO;
import de.kraueterhaus.adtool.security.Credentials;
import de.kraueterhaus.adtool.security.PasswordSecurityHandler;

/**
 * Implementierung von Interface UserService.
 * 
 * @author www.kraueterhaus.de
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	/**
	 * {@inheritDoc }
	 */
	public List<User> getUsers()
	{
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	/**
	 * {@inheritDoc }
	 */
	public void saveUser(User user)
	{
		Credentials credentials = PasswordSecurityHandler.getInstance().getSecureCredentials(user.getPassword());
		user.setPassword(credentials.getEncryptedPassword());
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	/**
	 * {@inheritDoc }
	 */
	public User getUser(int id)
	{
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	/**
	 * {@inheritDoc }
	 */
	public void deleteUser(int id)
	{
		userDAO.deleteUser(id);
	}

	@Override
	@Transactional
	/**
	 * {@inheritDoc }
	 */
	public List<User> suche(String id)
	{
		return userDAO.getByUsername(id);
	}

}
