package de.kraueterhaus.adtool.business.service.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.kraueterhaus.adtool.model.intern.ADToolUser;
import de.kraueterhaus.adtool.persistence.dao.intern.ADToolUserDAO;
import de.kraueterhaus.adtool.security.Credentials;
import de.kraueterhaus.adtool.security.PasswordSecurityHandler;

/**
 * Implementation des Interface ADToolUserService. Zugriffsmöglichkeiten
 * innerhalb der Serviceschicht (Zweite Schicht) innerhalb der
 * Drei-Schichten-Architektur.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Service
public class ADToolUserServiceImpl implements ADToolUserService
{
	/**
	 * {@inheritDoc}
	 */
	@Autowired
	private ADToolUserDAO adUserDao;

	@Override
	@Transactional
	public ADToolUser getUser(String userName)
	{
		return adUserDao.getUser(userName);
	}

	@Override
	@Transactional
	/**
	 * {@inheritDoc }
	 */
	public void saveADToolUser(ADToolUser adUser)
	{
		Credentials credentials = PasswordSecurityHandler.getInstance().getSecureCredentials(adUser.getPassword());
		adUser.setPassword(credentials.getEncryptedPassword());
		adUser.setSalt(credentials.getSalt());
		adUserDao.saveUser(adUser);
	}

}
