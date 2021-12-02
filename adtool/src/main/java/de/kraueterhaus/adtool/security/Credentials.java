package de.kraueterhaus.adtool.security;

/**
 * POJO-Objekt (Plain Old Java Object) zur temporären Speicherung von
 * Anmeldeinformationen zum Durchreichen innerhalb verschiedener Schichten der
 * Anwendung. Zum Beispiel zwischen Sicherheit und Präsentation.
 * 
 * @author www.kraueterhaus.de
 *
 */
public class Credentials
{
	private String encryptedPassword;
	private byte[] salt;

	/**
	 * Konstruktor mit den nötigen Anmeldeattributen.
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
	 * Rückgabe ddes kodierten Kennwortes.
	 * 
	 * @return
	 */
	public String getEncryptedPassword()
	{
		return encryptedPassword;
	}

	/**
	 * Parameter für Sicherheitserhöhung bei Kennworterstellung.
	 * 
	 * @return
	 */
	public byte[] getSalt()
	{
		return salt;
	}

}
