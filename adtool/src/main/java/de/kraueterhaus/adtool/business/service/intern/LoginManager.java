package de.kraueterhaus.adtool.business.service.intern;

/**
 * Interface f�r Bereitstellung von Pr�fungsfunktionen zu Login-Vorg�ngen
 * innerhalb der ADTool-Anwendung.
 * 
 * Der genaue Prozessablauf wird in den einzelnen Implementierungs-Klassen festgelegt.
 * 
 * @author www.kraueterhaus.de
 *
 */
public interface LoginManager
{
	/**
	 * Pr�ft 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String userName, String password);
}
