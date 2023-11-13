package com.jspiders.cardekho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho.pojo.CarPOJO;
import com.jspiders.cardekho.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(CarPOJO pojo) {
		CarPOJO car =  repository.save(pojo);
		return car;
	}

	public CarPOJO deleteCar(int id) {
			
		CarPOJO pojo = repository.findById(id).orElse(null);
		
		if (pojo != null) {
			 repository.delete(pojo);
			 return pojo;
		}
		
		return null;
	}

	public CarPOJO findCar(int id) {
		CarPOJO pojo = repository.findById(id).orElse(null);
		return pojo;
	}

	public List<CarPOJO> findCars(String name) {
		List<CarPOJO> cars = new ArrayList<CarPOJO>();
		if (cars.isEmpty()) {
			cars = repository.findByCarnameContaining(name);
		}
		if (cars.isEmpty()) {
			cars = repository.findByBrandnameContaining(name);
		}
		if (cars.isEmpty()) {
			cars = repository.findByFueltypeContaining(name);
		}
		if (cars.isEmpty()) {
			try {
				long price =  Long.parseLong(name);
				cars = repository.findByPriceContaining(price);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return cars;
	}

	public CarPOJO updateCar(CarPOJO pojo) {
		CarPOJO car = repository.findById(pojo.getId()).orElse(null);
		if (car != null) {
			car.setCarname(pojo.getCarname());
			car.setFueltype(pojo.getFueltype());
			car.setBrandname(pojo.getBrandname());
			car.setPrice(pojo.getPrice());
			CarPOJO pojo2 = repository.save(car);
			return pojo2;
		}
		return null;
	}

	public List<CarPOJO> displayAll() {
		List<CarPOJO> cars = repository.findAll();
		return cars;
	}

}
