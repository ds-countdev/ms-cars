package mx.com.cars.service.operation.validate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import mx.com.cars.util.UtilExceptionManager;

import static mx.com.cars.util.UtilCarConstants.VALIDATE;

@Component()
public class CarGetOperationValidate {

	@Autowired
	private UtilExceptionManager util_exception_manager;

	public void car_get_validate(Integer car_id) {

		Optional.of(car_id).filter(id -> id > 0 && id instanceof Integer)
				.orElseThrow(() -> util_exception_manager.exception_manager(VALIDATE, HttpStatus.BAD_REQUEST.value()));
		
	}
}
