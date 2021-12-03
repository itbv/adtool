package de.kraueterhaus.adtool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.kraueterhaus.adtool.business.service.intern.LoginManager;
import de.kraueterhaus.adtool.model.Login;

/**
 * Interaktion des MVC-Paradigmas bezüglich Benutzer (UI/JSP-Views) 
 * --> über Model (Java-PoJo/Entities in package de.kraueterhaus.adtool.model)
 * --> gesteuert durch den Controller (Backend).
 * 
 * Steuert die GUI bezüglich des Loginvorgangs der ADTool-Anwendung.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Controller
public class ADToolRootController 
{
	public static final String VIEW_LOGIN_NAME		= "login";
	public static final String MODEL_LOGIN_NAME 	= "login";
	public static final String LOGIN_URL			= "/adtool/login";
	public static final String SESSION_TOKEN_KEY	= "sessionTokenKey";
	
	@Autowired
	private LoginManager loginManager;
	
	private final String SUCCESS = "redirect:/user/list";
	private final String FAILED	 = "redirect:/login";

	/**
	 * Bearbeitung des Login-Prozesses.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session)
	{
		Login login = new Login();
		session.setAttribute(MODEL_LOGIN_NAME, login);
		model.addAttribute(MODEL_LOGIN_NAME, login);
		return "login";
	}

	/**
	 * Prüfung der Zugriffsrecht auf die ADTool-Anwendung.
	 * 
	 * @param login
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/access", method = RequestMethod.POST)
	public ModelAndView accessControl(@ModelAttribute("login") Login login, HttpSession session)
	{
		String result = FAILED;
		
		String us = login.getUserName();
		String ps = login.getPassword();
		
		if (loginManager.checkLogin(us, ps)) {
			session.setAttribute(ADToolRootController.SESSION_TOKEN_KEY, SUCCESS);
			result = SUCCESS;
		}
		
		return new ModelAndView(result);
	}
}
