package de.kraueterhaus.adtool.business.service;

import java.util.List;

import de.kraueterhaus.adtool.model.User;

public interface UserService
{
	public List<User> getUsers();

	public void saveUser(User user);

	public User getUser(int id);

	public void deleteUser(int id);
}
