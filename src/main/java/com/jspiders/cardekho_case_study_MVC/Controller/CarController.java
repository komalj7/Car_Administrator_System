package com.jspiders.cardekho_case_study_MVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo;
import com.jspiders.cardekho_case_study_MVC.Service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService service;

	// Home Page Controller...
	@GetMapping("/home")
	public String homePage() {
		return "Home";
	}

	@GetMapping("/add")
	public String addPage(ModelMap map) { 
		List<CarPojo> cars = service.findAllCar();
		
		if (!cars.isEmpty()) {
			map.addAttribute("cars", cars);
			return "Add";
		}
		return "Add";
	}

	@PostMapping("/add")
	public String AddCar(@RequestParam String carName, @RequestParam String carBrand, @RequestParam String carFuel,
			@RequestParam double carPrice, ModelMap map) {

		CarPojo pojo = service.addCar(carName, carBrand, carFuel, carPrice);

		// Success
		if (pojo != null) {
			map.addAttribute("msg", "Car Data Added Successfully");
			List<CarPojo> cars = service.findAllCar();
			map.addAttribute("cars", cars);
			return "Add";
		}
		// Failure
		map.addAttribute("msg", "Car Data Not Added..!");
		List<CarPojo> cars = service.findAllCar();
		if (!cars.isEmpty()) {
			map.addAttribute("cars", cars);
			return "Add";
		}
		return "Add";
	}

	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}

	@PostMapping("/search")
	public String searchCar(@RequestParam int id, ModelMap map) {
		CarPojo pojo = service.searchCar(id);
		// Success
		if (pojo != null) {
			map.addAttribute("car", pojo);
			map.addAttribute("msg", "Car Data Founded...!");
			return "Search";
		}
		// Failure
		map.addAttribute("msg", "Data Not Found");
		return "Search";
	}

	@GetMapping("/update")
	public String updatePage(ModelMap map) {
		List<CarPojo> cars = service.findAllCar();
		map.addAttribute("cars", cars);
		return "Update";
	}

	// Update form Controller

	@PostMapping("/update")
	public String updateCar(@RequestParam int id, ModelMap map) {

		CarPojo pojo = service.searchCar(id);

		// Success
		if (pojo != null) {
			map.addAttribute("pojo", pojo);
			return "Update";
		}
		// faliure

		List<CarPojo> cars = service.findAllCar();
		map.addAttribute("cars", cars);
		map.addAttribute("msg", "Student Data Not Foubnd");
		return "Update";
	}

	// update form controller

	@PostMapping("/updateCar")
	public String update(@RequestParam int id, @RequestParam String carName, @RequestParam String carBrand,
			@RequestParam String carFuel, @RequestParam double carPrice, ModelMap  map) {
		CarPojo pojo = service.updateCar(id, carName, carBrand, carFuel, carPrice);
		
		//Success
		if (pojo != null) {

			List<CarPojo> cars = service.findAllCar();
			map.addAttribute("msg", "Car Updated Successfully");
			map.addAttribute("cars", cars);
			return "Update";
		}
		//Failure
		List<CarPojo> cars = service.findAllCar();
		map.addAttribute("msg", "data Not updated");
		map.addAttribute("cars", cars);
		return "Update";
	}

	@GetMapping("/remove")
	public String removepage(ModelMap map) {
		List<CarPojo> cars = service.findAllCar();
		map.addAttribute("cars", cars);
		return "Remove";
	}

	@PostMapping("/remove")
	public String removeCar(@RequestParam int id, ModelMap map) {
		CarPojo pojo = service.removeCar(id);
		List<CarPojo> cars = service.findAllCar();
		// Success
		if (pojo != null) {
			map.addAttribute("msg", "Data Removed..");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		// Failure
		map.addAttribute("msg","Data Not Removes");
		map.addAttribute("cars",cars);
		return "Remove";
	}

}
