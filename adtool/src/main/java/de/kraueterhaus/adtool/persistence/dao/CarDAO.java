package de.kraueterhaus.adtool.persistence.dao;

import java.util.List;

import de.kraueterhaus.adtool.model.Car;

public interface CarDAO
{

	public List<Car> getCars();

	public void saveCar(Car car);

	public Car getCar(int id);

	public void deleteCar(int id);

}
