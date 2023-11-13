package com.jspiders.cardekho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.cardekho.pojo.CarPOJO;

public interface CarRepository extends JpaRepository<CarPOJO, Integer> {
	
	public List<CarPOJO> findByCarnameContaining(String carname);
	public List<CarPOJO> findByBrandnameContaining(String brandname);
	public List<CarPOJO> findByFueltypeContaining(String fueltype);
	public List<CarPOJO> findByPriceContaining(long price);

}
