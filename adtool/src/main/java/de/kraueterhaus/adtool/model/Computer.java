package de.kraueterhaus.adtool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "computer_table")
public class Computer
{

	public Computer()
	{

	}

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column
	private String computerName;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private ComputerTyp computerTyp;

	@Column
	private int foreignUserId;

	public int getForeignUserId()
	{
		return foreignUserId;
	}

	public void setForeignUserId(int foreignUserId)
	{
		this.foreignUserId = foreignUserId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getComputerName()
	{
		return computerName;
	}

	public void setComputerName(String computerName)
	{
		this.computerName = computerName;
	}

	public ComputerTyp getComputerTyp()
	{
		return computerTyp;
	}

	public void setComputerTyp(ComputerTyp computerTyp)
	{
		this.computerTyp = computerTyp;
	}

}
