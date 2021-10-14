package de.kraueterhaus.adtool.persistence.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.kraueterhaus.adtool.model.User;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	//Konstruktor von User
	public UserDAOImpl()
	{

	}
//Liste
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

	@Override
	public void saveUser(User user)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);		
	}

	@Override
	public User getUser(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);		
	}

}
