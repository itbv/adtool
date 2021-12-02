package de.kraueterhaus.adtool.business.service.intern;

/**
 * Interface für Bereitstellung von Prüfungsfunktionen zu Login-Vorgängen
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
	 * Prüft 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String userName, String password);
}
