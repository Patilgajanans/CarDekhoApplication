package com.jspiders.cardekho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho.pojo.CarPOJO;
import com.jspiders.cardekho.response.CarResponse;
import com.jspiders.cardekho.service.CarService;

@RestController
@CrossOrigin("*")
public class CarController {
	
	@Autowired
	private CarService service;
	
	@PostMapping("/add")
	public CarResponse addCar(@RequestBody CarPOJO pojo) {
		CarPOJO car =  service.addCar(pojo);
		
		if (car != null) {
			return new CarResponse("Car Successfully Added In DataBase", car, null);
		}
		
		return new CarResponse("Car Not Added", null, null);
	}
	
	@PostMapping("/update")
	public CarResponse updateCar(@RequestBody CarPOJO pojo) {
		CarPOJO car =  service.updateCar(pojo);
		
		if (car != null) {
			return new CarResponse("Car Updated Successfully", car, null);
		}
		
		return new CarResponse("Car Not Updated", null, null);
	}
	
	@DeleteMapping("/delete/{id}")
	public CarResponse deleteCar(@PathVariable int id) {
		CarPOJO car =  service.deleteCar(id);
		
		if (car != null) {
			return new CarResponse("Details Deleted Successfully !", car, null);
		}
		
		return new CarResponse("Details Not Deleted !", null, null);
	}
	
	@GetMapping("/searchbyId/{id}")
	public CarResponse searchCarId(@PathVariable int id) {
		CarPOJO car =  service.findCar(id);
		
		if (car != null) {
			return new CarResponse("Details Found !", car, null);
		}
		
		return new CarResponse("Details Not Found !", null, null);
	}
	
	@GetMapping("/searchby/{name}")
	public CarResponse searchCar(@PathVariable String name) {
		List<CarPOJO> cars =  service.findCars(name);
		
		if (!cars.isEmpty() ) {
			return new CarResponse("Details Found !", null, cars);
		}
		
		return new CarResponse("Details Not Found !", null, null);
	}
	
	@GetMapping("/displayAll")
	public CarResponse displayAll() {
		List<CarPOJO> cars =  service.displayAll();
		
		if (!cars.isEmpty()) {
			return new CarResponse("Details Found !", null, cars);
		}
		
		return new CarResponse("Details Not Found !", null, null);
	}

}
