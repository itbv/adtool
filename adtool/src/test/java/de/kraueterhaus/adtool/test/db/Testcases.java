package de.kraueterhaus.adtool.test.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
	
import de.kraueterhaus.adtool.business.service.UserService;
import de.kraueterhaus.adtool.model.User;
import de.kraueterhaus.adtool.security.Credentials;
import de.kraueterhaus.adtool.security.PasswordSecurityHandler;
import de.kraueterhaus.adtool.test.config.HibernatePersistenceTestContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernatePersistenceTestContext.class, loader = AnnotationConfigContextLoader.class)
@Transactional
@ComponentScan(basePackages =
{ "de.kraueterhaus.adtool.business.service", "de.kraueterhaus.adtool.persistence.dao" })
public class Testcases
{
	public Testcases()
	{
		super();
	}

	@Autowired
	UserService service;

	@Test
	public void testUsers()
	{
		List<User> users = service.getUsers();

		assertEquals(0, users.size());

		User user = new User();
		
		assertEquals(0, user.getId());
 
		user.setDepartment("department 1");
		user.setEmail("mail1");
		user.setPassword("DasIstEinKennwort");

		service.saveUser(user);

		assertEquals(1, user.getId());

		users = service.getUsers();

		assertEquals(1, users.size());
	}

	@Test
	public void testPasswordHandler()
	{
		Credentials cr = PasswordSecurityHandler.getInstance().getSecureCredentials("ABC123&");

		assertNotEquals(null, cr);
		assertNotEquals(null, cr.getEncryptedPassword());
		assertNotEquals(0, cr.getSalt());
		
		Credentials cr2 = PasswordSecurityHandler.getInstance().getSecureCredentials("ABC123&");
		assertNotEquals(cr.getEncryptedPassword(), cr2.getEncryptedPassword());
		assertNotEquals(cr.getSalt(), cr2.getSalt());
		
		String securedPassword =  PasswordSecurityHandler.getInstance().getSecurePassword("ABC123&", cr.getSalt());
		assertEquals(securedPassword, cr.getEncryptedPassword());
	}
}



