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

import de.kraueterhaus.adtool.business.service.CarService;
import de.kraueterhaus.adtool.model.Car;

@Controller
@RequestMapping("/car")
public class CarController
{

	@Autowired
	private CarService carService;

	@GetMapping("/list")
	public String listCars(Model model)
	{
		List<Car> cars = carService.getCars();
		model.addAttribute("cars", cars);
		return "list-cars";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model)
	{
		Car car = new Car();
		model.addAttribute("car", car);
		return "car-form";
	}

	@PostMapping("/saveCar")
	public String saveCar(@ModelAttribute("car") Car car)
	{
		carService.saveCars(car);
		return "redirect:/car/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("carId") int id, Model theModel)
	{
		Car car = carService.getCar(id);
		theModel.addAttribute("car", car);
		return "car-form";
	}

	@GetMapping("/delete")
	public String deleteCar(@RequestParam("carId") int id)
	{
		carService.deleteCar(id);
		return "redirect:/car/list";
	}
}
