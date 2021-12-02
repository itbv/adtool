package de.kraueterhaus.adtool.business.service;

import java.util.List;

import de.kraueterhaus.adtool.model.User;

/**
 * Festlegungen für User-Service Prozesse. Führt - wenn nötig - Prozesse wie
 * Validierungen oder Login-Prüfungen usw. aus, bevor eine Weitergabe des
 * User-Objektes an eine zu weiterverarbeitende Schicht erfolgt.
 * 
 * Der genaue Prozessablauf wird in den einzelnen Implementierungklassen festgelegt.
 * 
 * @author www.kraueterhaus.de
 *
 */
public interface UserService
{
	/**
	 * Rückgabe einer Liste von Benutzern.
	 * 
	 * @return
	 */
	public List<User> getUsers();

	/**
	 * Speichern eines Benutzers.
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * Rückgabe eines bestimmten Nutzers anhand einer ID.
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id);

	/**
	 * Löschen eines bestimmten Benutzers anhand einer ID.
	 * 
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * Suche eines bestimmten Benuters anhand einer ID.
	 * 
	 * @param id
	 * @return
	 */
	public List<User> suche(String id);

}
