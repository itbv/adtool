package de.kraueterhaus.adtool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Interaktion des MVC-Paradigmas bez�glich Benutzer (UI/JSP-Views) --> �ber
 * Model (Java-PoJo/Entities in package de.kraueterhaus.adtool.model) -->
 * gesteuert durch den Controller (Backend).
 * 
 * �bernimmt Logout-Funktionen, welche durch den Benutzer ausgel�st werden. Alle
 * neu zu erstellenden MVC-Controller (auf Basis von Sring-MVC
 * <code>org.springframework.stereotype.Controller</code>) m�ssen diese Klasse
 * implementieren.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Controller
public class MainController
{

	/**
	 * Zu�cksetzen der Session, so dass eine Interaktion mit der Anwendung nur noch
	 * nach erfolgreicher Neuanmeldung erfolgen kann.
	 * 
	 * @return
	 */
	@GetMapping("/logout")
	public String logout()
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		session.removeAttribute(ADToolRootController.SESSION_TOKEN_KEY);

		return "forward:/login";
	}
}
