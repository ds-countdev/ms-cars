package mx.com.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mx.com.cars.model.CarGetResponse;
import mx.com.cars.model.CarPostRequest;
import mx.com.cars.service.CarGetService;

@RestController
public class CarControllerImpl implements CarController{

	@Autowired
	private CarGetService car_service;

	@Override
	public ResponseEntity<CarGetResponse> get_car_by_id(Long car_id) {
		return car_service.car_get_service(car_id);
	}

	@Override
	public ResponseEntity<String> car_post(CarPostRequest car_post_request) {
		return ResponseEntity.ok("hello");
	}
	
	
}
