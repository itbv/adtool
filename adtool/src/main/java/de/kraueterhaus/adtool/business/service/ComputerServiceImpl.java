package de.kraueterhaus.adtool.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.kraueterhaus.adtool.model.Computer;
import de.kraueterhaus.adtool.persistence.dao.ComputerDAO;

@Service
public class ComputerServiceImpl implements ComputerService
{
	@Autowired
	private ComputerDAO computerDAO;

	@Override
	public List<Computer> getComputers()
	{
		return computerDAO.getComputers();
	}

	@Override
	public void saveComputer(Computer computer)
	{
		computerDAO.saveComputer(computer);		
	}

	@Override
	public Computer getComputer(int id)
	{
		return computerDAO.getComputer(id);
	}

	@Override
	public void deleteComputer(int id)
	{
		computerDAO.deleteComputer(id);
	}

}
