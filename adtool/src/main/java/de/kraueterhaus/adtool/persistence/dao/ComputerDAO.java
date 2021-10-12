package de.kraueterhaus.adtool.persistence.dao;

import java.util.List;

import de.kraueterhaus.adtool.model.Computer;

public interface ComputerDAO
{
	public List<Computer> getComputers();

	public void saveComputer(Computer computer);

	public Computer getComputer(int id);

	public void deleteComputer(int id);
}
