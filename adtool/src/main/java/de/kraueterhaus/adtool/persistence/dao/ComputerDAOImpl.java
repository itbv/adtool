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

import de.kraueterhaus.adtool.model.Computer;

@Repository
public class ComputerDAOImpl implements ComputerDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public ComputerDAOImpl()
	{

	}

	@Override
	public List<Computer> getComputers()
	{
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Computer> cq = cb.createQuery(Computer.class);
		Root<Computer> root = cq.from(Computer.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		
		List<Computer> computers = query.getResultList();
		
		return computers;
	}

	@Override
	public void saveComputer(Computer computer)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(computer);		
	}

	@Override
	public Computer getComputer(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Computer computer = currentSession.get(Computer.class, id);
		return computer;
	}

	@Override
	public void deleteComputer(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Computer computer = session.byId(Computer.class).load(id);
		session.delete(computer);		
		
	}

}
