package de.kraueterhaus.adtool.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Der Klasse basiert auf dem sog. Secure Hash Algorithmus und bezeichnet eine
 * standardisierte kryptologische Hashfunktion, welche zur Erstellung einer
 * digitalen Signatur für die Verschlüsselung von Kennwörtern innerhalb der
 * ADTool-Anwendung verwendet wird.
 * 
 * Dieser Sicherheitsstandard entspricht dem Protokoll von Active-Directory,
 * welches innerhalb von ADTool berücksichtigt werden muss.
 * 
 * Zusätzlich wird zur individualiserten Signatur noch ein sog. Salting
 * eingesetzt, welches ein einmaliges kodiertes Kennwort liefert, selbst wenn
 * zwei Benutzer das gleiche Kennwort verwenden (ausschließlich für Prozesse
 * innerhalb der ADTool-Anwendung).
 * 
 * @author www.kraueterhaus.de
 *
 */
public class PasswordSecurityHandler
{
	private static final String SHA_256 = "SHA-256";

	public static synchronized PasswordSecurityHandler getInstance()
	{
		return new PasswordSecurityHandler();
	}

	/**
	 * Erstellt eine digitale Signatur für Kennwortverschlüsselung. Hierzu wird ein
	 * Salt-Wert auf Byte-Basis mitgeliefert. Dieser muss zusammen mit dem kodierten
	 * Kennwort abgespeichert werden.
	 * 
	 * @param password
	 * @return
	 */
	public Credentials getSecureCredentials(String password)
	{
		final byte[] salt = this.getSalt();
		String generatedPassword = this.getSecurePassword(password, salt);

		return new Credentials(generatedPassword, salt);
	}

	/**
	 * Liefert einen kodierten String anhand eines lesbaren Kennwortes und einem
	 * Salt-Wert (bytes) zur Überprüfung und Abgleichung z. B. mit Anmeldedaten
	 * eines Benutzers in der Datenbank.
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public String getSecurePassword(String password, byte[] salt)
	{
		String generatedPassword = null;
		try
		{
			StringBuilder builder = new StringBuilder();
			MessageDigest digest = MessageDigest.getInstance(SHA_256);
			digest.update(salt);
			byte[] bytes = digest.digest(password.getBytes());

			for (int i = 0; i < bytes.length; i++)
			{
				builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = builder.toString();
		} catch (NoSuchAlgorithmException exc)
		{
			exc.printStackTrace();
		}

		return generatedPassword;
	}

	/**
	 * Zufällig generierter Byte-Wert zur Signaturerstellung.
	 * 
	 * @return
	 */
	private byte[] getSalt()
	{
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}
}
