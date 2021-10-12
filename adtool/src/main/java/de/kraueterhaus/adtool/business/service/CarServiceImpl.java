package de.kraueterhaus.adtool.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.kraueterhaus.adtool.model.Car;
import de.kraueterhaus.adtool.persistence.dao.CarDAO;

@Service
public class CarServiceImpl implements CarService
{

	@Autowired
	private CarDAO carDAO;

	public CarServiceImpl()
	{

	}

	@Override
	@Transactional
	public List<Car> getCars()
	{
		return carDAO.getCars();
	}

	@Override
	@Transactional
	public void saveCars(Car car)
	{
		carDAO.saveCar(car);
	}

	@Override
	@Transactional
	public Car getCar(int theId)
	{
		return carDAO.getCar(theId);
	}

	@Override
	@Transactional
	public void deleteCar(int id)
	{
		carDAO.deleteCar(id);
	}
}
