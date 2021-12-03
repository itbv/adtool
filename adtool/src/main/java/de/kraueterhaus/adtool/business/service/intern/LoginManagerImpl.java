package de.kraueterhaus.adtool.business.service.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kraueterhaus.adtool.model.intern.ADToolUser;
import de.kraueterhaus.adtool.security.PasswordSecurityHandler;

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

	/**
	 * Prüft den Zugriff über Benutzername und Kennwort. Die Übergabe der
	 * Anmeldedaten durch den Benutzer über die GUI wird mit den in der Persistenz
	 * abgelegten Daten verglichen.
	 * 
	 * Das Kennwort muss dem Standard des <code>PasswordSecurityHandler</code>
	 * (SHA-256) genügen.
	 */
	@Override
	public boolean checkLogin(String userName, String password)
	{
		ADToolUser user = userService.getUser(userName);
		
		if(user == null) {
			return false;
		}
		
		String encryptedPassword = PasswordSecurityHandler.getInstance().getSecurePassword(password, user.getSalt());
		boolean result = user != null && user.getPassword().equals(encryptedPassword);

		return result;
	}

}
