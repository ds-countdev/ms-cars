package mx.com.cars.config.model.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMessages {
	
	@Value("${message.service.success.find}")
	private String message_success_find;
	
	@Value("${message.service.exceptions.validate}")
	private String validate_message;
	
	@Value("${message.test}")
	private String test;

}
