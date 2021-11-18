package de.kraueterhaus.adtool.business.service.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

@Component
public class LoginManagerImpl implements LoginManager
{	
	@Autowired
	ADToolUserService userService;
	
	private LoginManagerImpl()
	{

	}
	
	@Override
	public boolean checkLogin(String userName, String password)
	{
		ADToolUser user = userService.getUser(userName);
		boolean result = user != null && user.getPassword().equals(password);
		return result;
	}

}
