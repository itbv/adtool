package de.kraueterhaus.adtool.persistence.dao.intern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

@Repository
public class ADToolUserDAOImpl implements ADToolUserDAO
{
	public ADToolUserDAOImpl()
	{

	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ADToolUser getUser(String userName)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		ADToolUser user = currentSession.get(ADToolUser.class, userName);
		return user;
	}
	
}
