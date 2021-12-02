package de.kraueterhaus.adtool.model;

/**
 * POJO (Plain Old Java Object) als Container für Benutzerzugangsdaten.
 * 
 * @author IT-Beratung Vogel
 *
 */
public class Login
{
	private String userName;

	private String password;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
