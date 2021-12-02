package de.kraueterhaus.adtool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.kraueterhaus.adtool.business.service.UserService;
import de.kraueterhaus.adtool.model.User;

/**
 * Interaktion des MVC-Paradigmas bezüglich Benutzer (UI/JSP-Views) --> über
 * Model (Java-PoJo/Entities in package de.kraueterhaus.adtool.model) -->
 * gesteuert durch den Controller (Backend).
 * 
 * Übernimmt alle Aufgaben zur Steuerung der UI-View der Benutzerliste.
 * 
 * @author www.kraueterhaus.de
 *
 */
@Controller
@RequestMapping("/user")
public class UserControler extends MainController
{

	/**
	 * Default-Konstruktor ohne implementierte Funktion. Wird von Spring benötigt.
	 */
	public UserControler(HttpSession session)
	{

	}

	@Autowired
	private UserService userService;

	/**
	 * Initialsierung der View mit allen Benutzern der Anwendung.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String listUsers(Model model)
	{
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());

		return "list-users";
	}
	
	/**
	 * Erstellung eines neuen Benutzers.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showForm")
	public String showFormForAdd(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "user-form";
	}

	/**
	 * Speichern eines neu erstellten Benutzers.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, params = "save")
	public String saveUser(@Valid @ModelAttribute("user") User user)
	{
		userService.saveUser(user);
		return "redirect:/user/list";
	}

	/**
	 * Ändern der Attribute eines bestehenden Benutzers.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("userId") int id, Model model)
	{
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user-form";
	}

	/**
	 * Löschen eines durch den Login-Benutzer ausgewählten Benutzers.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int id)
	{
		userService.deleteUser(id);
		return "redirect:/user/list";
	}

	/**
	 * Suche für Autofill-Funktionen in der View/UI.
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/suche", method = RequestMethod.POST, params = "btnSuche")
	public String suche(@Valid @ModelAttribute("user") User user, Model model)
	{
		model.addAttribute("users", userService.suche(user.getSucheUsername()));

		return "list-users";
	}
}
