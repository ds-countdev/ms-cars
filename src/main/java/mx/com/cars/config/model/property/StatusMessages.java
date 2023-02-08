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
public class StatusMessages {

	@Value("${message.error_handler.code_400}")
	private String code_400;
	
	@Value("${message.error_handler.code_500")
	private String code_500;
}
