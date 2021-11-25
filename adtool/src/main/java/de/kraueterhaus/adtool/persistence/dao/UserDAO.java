package de.kraueterhaus.adtool.persistence.dao;

import java.util.List;

import de.kraueterhaus.adtool.model.User;

public interface UserDAO
{

	public List<User> getUsers();

	public void saveUser(User user);

	public User getUser(int id);

	public void deleteUser(int id);

	

	public List<User> getByUsername(String userName);
}
