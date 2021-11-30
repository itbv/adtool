package de.kraueterhaus.adtool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_table")
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
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

	@Column
	private String userName;

	@Column
	private String surname;

	@Column
	private String firstName;

	@Column
	private String department;

	@Column
	private String email;
	
	@Column
	private String pcName;
	
	@Column
	private String account;
	
	
	@Column
	private String state;
	
	@Transient
	private String sucheUsername;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getpcName()
	{
		return pcName;
	}

	public void setPcName(String pcName)
	{
		this.pcName = pcName;
	}
	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}
	
	
	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getSucheUsername()
	{
		return sucheUsername;
	}

	public void setSucheUsername(String sucheUsername)
	{
		this.sucheUsername = sucheUsername;
	}

}



