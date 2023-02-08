package mx.com.cars.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cars.BuilderFactory;
import mx.com.cars.model.CarModel;
import mx.com.cars.service.operation.persistence.CarGetOperationPersistence;
import mx.com.cars.service.operation.response.CarGetOperationResponse;
import mx.com.cars.service.operation.validate.CarGetOperationValidate;
import mx.com.errors.handler.exception.ErrorsHandlerException;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CarGetServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(CarGetServiceTest.class);

	@InjectMocks
	private CarGetService car_service;

	@Mock
	private CarGetOperationValidate operation_validate;

	@Mock
	private CarGetOperationPersistence operation_persistence;

	@Mock
	private CarGetOperationResponse operation_response;

	private CarModel car_model = BuilderFactory.get_car_model();
	
	@Test
	@DisplayName("get_car_service_success")
	void test_for_car_service_when_procedure_is_success() {
		operation_validate.car_get_validate(1);
		LOG.info(car_model.getName());
		when(operation_persistence.car_get_persistence(1L)).thenReturn(car_model);
		when(operation_response.car_get_response(car_model)).thenReturn(BuilderFactory.get_car_standard_response());

		assertNotNull(car_service.car_get_service(1L));
	}

	@Test
	@DisplayName("get_car_service_validate")
	void test_for_car_service_when_car_id_is_negative() {
		doThrow(new ErrorsHandlerException("Error to find", "Error to validate key", "class name", "400"))
				.when(operation_validate).car_get_validate(-1);
		
		ErrorsHandlerException error = assertThrows(ErrorsHandlerException.class, ()-> car_service.car_get_service(-1L));
		LOG.info(error.getDescription());
		String description = "Error to validate key";
		assumeTrue(error.getDescription().equals(description));

	}
}
