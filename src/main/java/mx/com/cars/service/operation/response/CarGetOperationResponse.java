package mx.com.cars.service.operation.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mx.com.cars.config.model.property.ServiceMessages;
import mx.com.cars.model.CarGetResponse;
import mx.com.cars.model.CarGetResponseData;
import mx.com.cars.model.CarModel;
import mx.com.cars.model.Status;

@Component
public class CarGetOperationResponse {

	@Autowired
	private ServiceMessages service_messages;

	public ResponseEntity<CarGetResponse> car_get_response(CarModel car_model) {
		return ResponseEntity.status(HttpStatus.OK).body(new CarGetResponse(
				new Status(HttpStatus.OK.value(), service_messages.getMessage_success_find()),
				new CarGetResponseData(car_model)));
	}
}
