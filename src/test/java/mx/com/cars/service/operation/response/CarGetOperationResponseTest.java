package mx.com.cars.service.operation.response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import mx.com.cars.BuilderFactory;
import mx.com.cars.config.model.property.ServiceMessages;
import mx.com.cars.model.CarGetResponse;
import mx.com.cars.model.CarModel;
import mx.com.cars.model.Status;

@ExtendWith(MockitoExtension.class)
class CarGetOperationResponseTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CarGetOperationResponseTest.class);
	
	@InjectMocks
	private CarGetOperationResponse car_get_operation_response;
	
	@Mock
	private ServiceMessages service_messages;

	@Test
	@DisplayName("operation_success_response_1")
	void test_for_operation_success_response_when_car_exist() {
		
		when(service_messages.getMessage_success_find()).thenReturn(BuilderFactory.create_service_messages().getMessage_success_find());
		
		ResponseEntity<CarGetResponse> car_get_response = car_get_operation_response.car_get_response(BuilderFactory.get_car_model());
		LOG.info(car_get_response.getStatusCode().toString());
		
		assertNotNull(car_get_response);
		
		Status status = car_get_response.getBody().getStatus();
		CarModel car_model = car_get_response.getBody().getCar_get_response_data().getCar();
		
		assertAll(
				()-> assertEquals(200, status.getStatus_code()),
				()-> assertEquals("Succesful search", status.getDescription()),
				()-> assertEquals("Ferrari 408", car_model.getName()),
				()-> assertEquals("RED" , car_model.getColor()),
				()-> assertEquals("408", car_model.getModel()),
				()-> assertEquals("03/02/2015", car_model.getCreated().toString()),
				()-> assertEquals("340.0 km/h" , car_model.getVelocity()));
		
		
	}

}
