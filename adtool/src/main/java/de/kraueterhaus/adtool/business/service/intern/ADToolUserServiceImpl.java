package de.kraueterhaus.adtool.business.service.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.kraueterhaus.adtool.model.intern.ADToolUser;
import de.kraueterhaus.adtool.persistence.dao.intern.ADToolUserDAO;

@Service
public class ADToolUserServiceImpl implements ADToolUserService
{
	@Autowired
	private ADToolUserDAO userDao;

	@Override
	@Transactional
	public ADToolUser getUser(String userName)
	{
		return userDao.getUser(userName);
	}

}
