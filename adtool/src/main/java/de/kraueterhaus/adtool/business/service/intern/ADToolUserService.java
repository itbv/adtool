package de.kraueterhaus.adtool.business.service.intern;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

/**
 * Service zur Verwaltung von Ad-Tool Benutzern.
 * 
 * Der genaue Prozessablauf wird in den einzelnen Implementierungs-Klassen festgelegt.
 * 
 * @author www.kraueterhaus.de
 *
 */
public interface ADToolUserService
{
	/**
	 * Liefert einen ADTool-Benutzer durch Nutzername.
	 * 
	 * @param userName
	 * @return
	 */
	public ADToolUser getUser(String userName);

	/**
	 * Speichern eines ADTool-Benutzers.
	 * 
	 * @param user
	 */
	public void saveADToolUser(ADToolUser user);
}
