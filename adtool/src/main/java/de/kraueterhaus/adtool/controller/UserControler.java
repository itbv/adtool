package de.kraueterhaus.adtool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.kraueterhaus.adtool.business.service.UserService;
import de.kraueterhaus.adtool.model.User;

@Controller
@RequestMapping("/user")
public class UserControler 
{

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listUsers(Model model)
	{
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "list-users";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user)
	{
		userService.saveUser(user);
		return "redirect:/user/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("userId") int id, Model model)
	{
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user-form";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int id)
	{
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
}
