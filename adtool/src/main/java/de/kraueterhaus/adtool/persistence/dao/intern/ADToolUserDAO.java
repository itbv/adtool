package de.kraueterhaus.adtool.persistence.dao.intern;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

/**
 * Gewährleistet die Persistierung eines Objektes aus dem package
 * <code>de.kraueterhaus.adtool.model</code>.
 * 
 * Wo und wie die Persistierung der genannten Objekte erfolgt (ob Datenbank oder
 * Datei), wird in den einzelnen Implementationen dieser Schnittstelle
 * festgelegt.
 * 
 * @author ww.kraeuterhaus.de
 *
 */
public interface ADToolUserDAO
{
	/**
	 * Liefert einen Benutzer anhand des Benutzernamens.
	 * 
	 * @param userName
	 * @return
	 */
	public ADToolUser getUser(String userName);

	/**
	 * Speichert den zu übergebenden ADTool-Benutzer.
	 * 
	 * @param user
	 */
	public void saveUser(ADToolUser user);

}
