package de.kraueterhaus.adtool.persistence.dao.intern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

/**
 * Persistierung eines User-Objektes auf einer Datenbank, welche in der Klasse
 * <code>HibernatePersistenceContext</code> definiert wird.
 * 
 * Zugriff auf die Datenbank um einen ADTool-Benutzer zu verwalten.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Repository
public class ADToolUserDAOImpl implements ADToolUserDAO
{
	public ADToolUserDAOImpl()
	{

	}
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ADToolUser getUser(String userName)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		ADToolUser user = currentSession.get(ADToolUser.class, userName);
		return user;
	}

	@Override
	public void saveUser(ADToolUser user)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}
	
}
