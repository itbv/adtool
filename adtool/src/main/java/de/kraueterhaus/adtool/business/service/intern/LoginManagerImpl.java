package de.kraueterhaus.adtool.business.service.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.kraueterhaus.adtool.model.intern.ADToolUser;
import de.kraueterhaus.adtool.security.PasswordSecurityHandler;

/**
 * Bereitsstellung von Login-Pr�fungen f�r Zugriffe auf die ADTool-Anwendung.
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
	 * Default-Konstruktor ohne implementierte Funktion. Wird von Spring ben�tigt.
	 */
	private LoginManagerImpl()
	{
		super();
	}

	/**
	 * Pr�ft den Zugriff �ber Benutzername und Kennwort. Die �bergabe der
	 * Anmeldedaten durch den Benutzer �ber die GUI wird mit den in der Persistenz
	 * abgelegten Daten verglichen.
	 * 
	 * Das Kennwort muss dem Standard des <code>PasswordSecurityHandler</code>
	 * (SHA-256) gen�gen.
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
