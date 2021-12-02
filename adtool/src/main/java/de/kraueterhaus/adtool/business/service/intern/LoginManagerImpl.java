package de.kraueterhaus.adtool.business.service.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kraueterhaus.adtool.model.intern.ADToolUser;

/**
 * Bereitsstellung von Login-Prüfungen für Zugriffe auf die ADTool-Anwendung.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Component
public class LoginManagerImpl implements LoginManager
{
	@Autowired
	ADToolUserService userService;

	/**
	 * Default-Konstruktor ohne implementierte Funktion. Wird von Spring benötigt.
	 */
	private LoginManagerImpl()
	{
		super();
	}

	@Override
	/**
	 * Prüft den Zugriff über Benutzername und Kennwort. Die Übergabe der
	 * Anmeldedaten durch den Benutzer über die GUI wird mit den in der Persistenz
	 * abgelegten Daten verglichen.
	 */
	public boolean checkLogin(String userName, String password)
	{
		ADToolUser user = userService.getUser(userName);
		boolean result = user != null && user.getPassword().equals(password);
		return result;
	}

}
