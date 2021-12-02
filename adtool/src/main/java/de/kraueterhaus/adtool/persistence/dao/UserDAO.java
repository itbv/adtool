package de.kraueterhaus.adtool.persistence.dao;

import java.util.List;

import de.kraueterhaus.adtool.model.User;

/**
 * Gewährleistet die Persistierung eines Objektes aus dem Paket/Namensraum
 * <code>de.kraueterhaus.adtool.model</code>.
 * 
 * Wo und wie die Persistierung der genannten Objekte erfolgt (ob Datenbank oder
 * Datei), wird in den einzelnen Implementationen dieser Schnittstelle
 * festgelegt.
 * 
 * @author www.kraeuterhaus.de
 *
 */
public interface UserDAO
{

	/**
	 * Liefert alle Benutzer.
	 * 
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * Speichert den zu übergebenden Benutzer.
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * Liefert einen bestimmten Benutzer anhand einer ID.
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id);

	
	/**
	 * Löscht einen bestimmten Benutzer anhand einer ID.
	 * 
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * Liefert einen bestimmten Benutzer anhand des Benutzernamens.
	 * 
	 * @param userName
	 * @return
	 */
	public List<User> getByUsername(String userName);
}
