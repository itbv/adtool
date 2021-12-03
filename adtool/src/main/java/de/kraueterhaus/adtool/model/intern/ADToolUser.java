package de.kraueterhaus.adtool.model.intern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Hibernate-Entity zur Persistierung der Objekte und deren Attribute auf einer Datenbank.
 * Dient auch als Model-Objekt zur Interaktion innerhalb der Ersten Schicht des MVC-Paradigmas.
 * 
 * Verknüpft mit Tabelle: adtool_user
 * 
 * @author www.kraueterhaus.de
 *
 */
@Entity
@Table(name = "adtool_user")
public class ADToolUser
{
	public ADToolUser()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column
	private String userName;

	@Column
	private String password;

	@Lob
	@Column
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] salt;

	public byte[] getSalt()
	{
		return salt;
	}

	public void setSalt(byte[] salt)
	{
		this.salt = salt;
	}
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
