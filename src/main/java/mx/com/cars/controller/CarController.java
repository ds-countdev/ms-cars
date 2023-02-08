package mx.com.cars.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import mx.com.cars.model.CarGetResponse;
import mx.com.cars.model.CarPostRequest;

public interface CarController {

	@GetMapping(value = "/car/{car_id}")
	public ResponseEntity<CarGetResponse> get_car_by_id(@PathVariable Long car_id);
	
	@PostMapping(value = "car")
	public ResponseEntity<String> car_post(@Valid @RequestBody CarPostRequest car_post_request);


}
