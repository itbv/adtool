package de.kraueterhaus.adtool.business.service;

import java.util.List;

import de.kraueterhaus.adtool.model.Computer;

public interface ComputerService 
{
	public List<Computer> getComputers();

	public void saveComputer(Computer computer);

	public Computer getComputer(int id);

	public void deleteComputer(int id);
}
