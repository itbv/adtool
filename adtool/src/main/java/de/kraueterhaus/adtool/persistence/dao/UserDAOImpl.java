package de.kraueterhaus.adtool.persistence.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.kraueterhaus.adtool.model.User;

/**
 * Persistierung eines User-Objektes auf einer Datenbank, welche in der Klasse
 * <code>HibernatePersistenceContext</code> definiert wird.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Default-Konstruktor ohne implementierte Funktion. Wird von Spring benötigt.
	 */
	public UserDAOImpl()
	{

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getUsers()
	{
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query query = session.createQuery(cq);

		List<User> users = query.getResultList();

		return users;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUser(User user)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getByUsername(String userName)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("userName", userName, MatchMode.ANYWHERE));

		List<User> users = criteria.list();
		return users;
	}

	/**
	 * Liefert einen Benutzer anhand des Primärschlüssels der Datenbank.
	 */
	@Override
	public User getUser(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		return user;
	}

	/**
	 *Löscht einen Benutzer auf der Datenbank anhand des Primärschlüssels.
	 */
	@Override
	public void deleteUser(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
	}

}
