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

import de.kraueterhaus.adtool.business.service.ComputerService;
import de.kraueterhaus.adtool.model.Computer;
import de.kraueterhaus.adtool.model.ComputerTyp;

@Controller
@RequestMapping("/computer")
public class ComputerController
{
	@Autowired
	private ComputerService computerService;

	@GetMapping("/list")
	public String listComputers(Model model)
	{
		List<Computer> computers = computerService.getComputers();
		model.addAttribute("computers", computers);
		return "list-computers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model)
	{
		Computer computer = new Computer();
		model.addAttribute("computer", computer);
		model.addAttribute("computerTypList", ComputerTyp.values());
		return "computer-form";
	}

	@PostMapping("/saveComputer")
	public String saveComputer(@ModelAttribute("computer") Computer computer)
	{
		computerService.saveComputer(computer);
		return "redirect:/computer/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("computerId") int id, Model model)
	{
		Computer computer = computerService.getComputer(id);
		model.addAttribute("computer", computer);
		return "computer-form";
	}

	@GetMapping("/delete")
	public String deleteComputer(@RequestParam("computerId") int id)
	{
		computerService.deleteComputer(id);
		return "redirect:/computer/list";
	}
}
