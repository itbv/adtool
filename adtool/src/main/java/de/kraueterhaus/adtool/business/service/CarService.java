package de.kraueterhaus.adtool.business.service;

import java.util.List;

import de.kraueterhaus.adtool.model.Car;

public interface CarService
{

	public List<Car> getCars();

	public void saveCars(Car car);

	public Car getCar(int id);

	public void deleteCar(int id);

}
