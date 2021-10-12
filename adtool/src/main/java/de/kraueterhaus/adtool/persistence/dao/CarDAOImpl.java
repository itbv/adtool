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

import de.kraueterhaus.adtool.model.Car;

@Repository
public class CarDAOImpl implements CarDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	public CarDAOImpl()
	{

	}

	@Override
	public List<Car> getCars()
	{
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);
		Root<Car> root = cq.from(Car.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void deleteCar(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Car book = session.byId(Car.class).load(id);
		session.delete(book);
	}

	@Override
	public void saveCar(Car car)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(car);
	}

	@Override
	public Car getCar(int theId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		Car car = currentSession.get(Car.class, theId);
		return car;
	}
}
