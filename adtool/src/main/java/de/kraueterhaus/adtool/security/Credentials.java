package de.kraueterhaus.adtool.security;

/**
 * POJO-Objekt (Plain Old Java Object) zur tempor�ren Speicherung von
 * Anmeldeinformationen zum Durchreichen innerhalb verschiedener Schichten der
 * Anwendung. Zum Beispiel zwischen Sicherheit und Pr�sentation.
 * 
 * @author www.kraueterhaus.de
 *
 */
public class Credentials
{
	private String encryptedPassword;
	private byte[] salt;

	/**
	 * Konstruktor mit den n�tigen Anmeldeattributen.
	 * 
	 * @param encryptedPassword
	 * @param salt
	 */
	public Credentials(String encryptedPassword, byte[] salt)
	{
		this.encryptedPassword = encryptedPassword;
		this.salt = salt;
	}

	/**
	 * R�ckgabe ddes kodierten Kennwortes.
	 * 
	 * @return
	 */
	public String getEncryptedPassword()
	{
		return encryptedPassword;
	}

	/**
	 * Parameter f�r Sicherheitserh�hung bei Kennworterstellung.
	 * 
	 * @return
	 */
	public byte[] getSalt()
	{
		return salt;
	}

}
