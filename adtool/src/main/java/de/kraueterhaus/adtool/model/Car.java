package de.kraueterhaus.adtool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "brandName")
	private String brandName;

	@Column(name = "ps")
	private String ps;

	@Column(name = "type")
	private String type;

	public Car()
	{

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getBrandName()
	{
		return brandName;
	}

	public void setBrandName(String brandName)
	{
		this.brandName = brandName;
	}

	public String getPs()
	{
		return ps;
	}

	public void setPs(String ps)
	{
		this.ps = ps;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "Car [id=" + id + ", brandName=" + brandName + ", ps=" + ps + ", type=" + type + "] Super-Info:" + super.toString();
	}

}
