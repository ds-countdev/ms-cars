package mx.com.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.cars.model.CarGetResponse;
import mx.com.cars.model.CarModel;
import mx.com.cars.service.operation.persistence.CarGetOperationPersistence;
import mx.com.cars.service.operation.response.CarGetOperationResponse;
import mx.com.cars.service.operation.validate.CarGetOperationValidate;

@Service
public class CarGetService {

	@Autowired
	private CarGetOperationValidate car_validate;

	@Autowired
	private CarGetOperationPersistence car_persistence;

	@Autowired
	private CarGetOperationResponse car_response;

	public ResponseEntity<CarGetResponse> car_get_service(Long car_id) {
		car_validate.car_get_validate(car_id.intValue());
		CarModel car = car_persistence.car_get_persistence(car_id);
		return car_response.car_get_response(car);
	}

}
