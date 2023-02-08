package mx.com.cars.service.operation.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.cars.repository.CarRepository;
import mx.com.cars.service.mapper.CarPostServiceMapper;

@Component
public class CarPostOperationPersistence {

	@Autowired
	private CarPostServiceMapper car_mapper;
	
	@Autowired
	private CarRepository car_repository;
	
	
}
