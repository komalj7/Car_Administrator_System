package com.jspiders.cardekho_case_study_MVC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_MVC.Pojo.CarPojo;
import com.jspiders.cardekho_case_study_MVC.Repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	public List<CarPojo> findAllCar() {
		List<CarPojo> carspojo = repository.findAllCar();
		return carspojo;
	}
	
	public CarPojo addCar(String carName, String carBrand, String carFuel, double carPrice) {
		CarPojo pojo = repository.addCar(carName, carBrand, carFuel, carPrice);
		return pojo;
	}

	

	public CarPojo searchCar(int id) {
		CarPojo pojo = repository.searchCar(id);
		return pojo;
	}

	public CarPojo updateCar(int id, String carName, String carBrand, String carFuel, double carPrice) {
		CarPojo pojo = repository.updateCar(id, carName, carBrand, carFuel, carPrice);
		return pojo;
	}

	public CarPojo removeCar(int id) {
		CarPojo pojo = repository.removeCar(id);
		return pojo;
	}


}
