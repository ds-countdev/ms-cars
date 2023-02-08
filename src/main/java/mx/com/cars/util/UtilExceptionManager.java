package mx.com.cars.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import mx.com.cars.config.model.property.ServiceMessages;
import mx.com.cars.config.model.property.StatusMessages;
import mx.com.errors.handler.exception.ErrorsHandlerException;

import static mx.com.cars.util.UtilCarConstants.VALIDATE;

@Component
public class UtilExceptionManager {

	@Autowired
	private ServiceMessages service_messages;
	
	@Autowired
	private StatusMessages status_messages;
	
	public ErrorsHandlerException exception_manager(String layer, Integer code) {
		String layer_error = null;
		String error_description = null;
		String code_status = null;
		
		if(code == HttpStatus.BAD_REQUEST.value()) {
			code_status = String.valueOf(HttpStatus.BAD_REQUEST);
			error_description = status_messages.getCode_400();
		}else if(code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			code_status = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR);
			error_description = status_messages.getCode_500();
		}
		
		switch(layer) {
		
		case VALIDATE:
			layer_error = service_messages.getValidate_message();
			
		}
		
		return new ErrorsHandlerException(layer_error, error_description, code_status, this.getClass().getName());
	}
}
