package mx.com.cars.service.operation.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.cars.model.CarModel;
import mx.com.cars.repository.CarRepository;
import mx.com.cars.repository.entity.Car;
import mx.com.cars.repostiory.mapper.CarGetRepositoryMapper;

@Component
public class CarGetOperationPersistence {
	
	@Autowired
	private CarGetRepositoryMapper car_mapper;
	
	@Autowired
	private CarRepository car_repository;

	public CarModel car_get_persistence(Long car_id) {
		Car car = car_repository.find_car_by_id(car_id).orElse(null);
		return car_entity_to_car_model(car);
	}
	
	public CarModel car_entity_to_car_model(Car car_entity) {
		return car_mapper.car_entity_to_car_model(car_entity);
	}
}
